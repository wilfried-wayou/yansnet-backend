# Multi-stage build pour optimiser la taille de l'image finale

# Stage 1: Build l'application avec Gradle
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app

# Copier les fichiers Gradle wrapper
COPY gradlew .
COPY gradlew.bat .
COPY gradle gradle/
COPY settings.gradle.kts .
COPY build.gradle.kts .

# Copier tous les modules
COPY application application/
COPY auth auth/
COPY common common/
COPY interaction interaction/
COPY message message/
COPY notification notification/
COPY post post/
COPY user user/

# Rendre gradlew exécutable et construire l'application
RUN chmod +x ./gradlew && \
    ./gradlew :application:build -x test --no-daemon

# Stage 2: Image finale légère avec JRE
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copier le JAR construit depuis le builder
COPY --from=builder /app/application/build/libs/*.jar app.jar

# Créer un utilisateur non-root pour la sécurité
RUN addgroup --system springuser && \
    adduser --system --ingroup springuser springuser

USER springuser

# Variables d'environnement (peuvent être overridées au runtime)
ENV SPRING_PROFILES_ACTIVE=prod \
    JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Exposer le port de l'application
EXPOSE 8085

# Healthcheck pour Docker Compose/Kubernetes
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8085/actuator/health || exit 1

# Lancer l'application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
