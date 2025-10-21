<<<<<<< HEAD
# Utiliser une étape de build séparée pour compiler l'application
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app

# Copier uniquement les fichiers nécessaires pour la construction
COPY . .


# Rendre gradlew exécutable et construire l'application
RUN cd application/ && chmod +x ./gradlew && ./gradlew build -x test --no-daemon

# Étape finale avec une image plus légère
=======
>>>>>>> 5f92e67 (clean and add db)
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

<<<<<<< HEAD
# Copier uniquement le JAR construit de l'étape précédente
COPY --from=builder /app/application/build/libs/application-1.0-SNAPSHOT.jar app.jar
=======
COPY . .
# Copier uniquement le JAR construit de l'étape précédente
COPY  application/build/libs/application-1.0-SNAPSHOT.jar app.jar
>>>>>>> 5f92e67 (clean and add db)

# Créer un utilisateur non-root pour des raisons de sécurité
RUN addgroup --system springuser && \
    adduser --system --ingroup springuser springuser
USER springuser

# Configuration de l'environnement de production
ENV SPRING_PROFILES_ACTIVE=prod
#    JAVA_TOOL_OPTIONS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

<<<<<<< HEAD
EXPOSE 8080
=======
EXPOSE 8080:8080
>>>>>>> 5f92e67 (clean and add db)

# Utiliser exec form pour permettre la propagation des signaux
ENTRYPOINT ["java", "-jar", "app.jar"]