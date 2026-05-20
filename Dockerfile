# ─────────────────────────────────────────────
# Stage 1 – Build
# ─────────────────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy Maven wrapper and pom first
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .
COPY mvnw.cmd .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests -B

# ─────────────────────────────────────────────
# Stage 2 – Runtime
# ─────────────────────────────────────────────
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Create non-root user
RUN groupadd --system appgroup && \
    useradd --system --gid appgroup --no-create-home appuser

# Copy built jar
COPY --from=builder /app/target/*.jar app.jar

# Permissions
RUN chown appuser:appgroup app.jar

USER appuser

# Expose port
EXPOSE 8080

# JVM optimizations
ENV JAVA_OPTS="-XX:+UseContainerSupport \
-XX:MaxRAMPercentage=75.0 \
-Djava.security.egd=file:/dev/./urandom"

# Start app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]