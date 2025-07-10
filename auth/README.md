# 🔐 Module Auth - Guide de Configuration Keycloak

Ce module gère l'authentification des utilisateurs en utilisant **Keycloak** comme serveur d'identité et **PostgreSQL** pour la persistance des données utilisateur.

---

## 🏗️ Architecture

Le module suit une **architecture en oignon (DDD)** avec :

- **Domain** : Entités métier pures (`User`, `AuthService`)
- **Application** : Services d'orchestration (`AuthApplicationService`)
- **Infrastructure** : Intégrations externes (Keycloak, Base de données)

### 🔄 Flux d'authentification

1. **Register** : Création utilisateur dans Keycloak + Base de données locale
2. **Login** : Validation credentials Keycloak → Récupération JWT token
3. **Token** : Utilisation du JWT token Keycloak pour les requêtes sécurisées

---

## 🚀 Configuration Keycloak Local

### 1. **Installation Keycloak**

#### Option A : Docker (Recommandé)
```bash
docker run -p 8080:8080 \
  -e KEYCLOAK_ADMIN=admin \
  -e KEYCLOAK_ADMIN_PASSWORD=admin \
  quay.io/keycloak/keycloak:latest \
  start-dev
```

#### Option B : Téléchargement manuel
1. Télécharger Keycloak depuis [keycloak.org](https://www.keycloak.org/downloads)
2. Extraire et démarrer : `./bin/kc.sh start-dev`

### 2. **Configuration initiale**

1. **Accéder à l'interface admin** : http://localhost:8080
2. **Se connecter** avec : `admin` / `admin`

### 3. **Création du Realm**

1. Cliquer sur **"Create Realm"**
2. **Nom** : `yansnet`
3. **Enabled** : `ON`
4. Cliquer **"Create"**

### 4. **Configuration du Client**

#### Étape 4.1 : Créer le client
1. Aller dans **Clients** → **Create client**
2. **Client ID** : `yansnet-client-test-01`
3. **Client type** : `OpenID Connect`
4. Cliquer **"Next"**

#### Étape 4.2 : Configurer les capabilities
1. **Client authentication** : `ON`
2. **Authorization** : `OFF`
3. **Standard flow** : `ON`
4. **Direct access grants** : `ON` ⚠️ **IMPORTANT**
5. **Implicit flow** : `OFF`
6. **Service accounts** : `OFF`
7. Cliquer **"Next"**

#### Étape 4.3 : Login settings
1. **Valid redirect URIs** : `http://localhost:8085/*`
2. **Web origins** : `http://localhost:8085`
3. Cliquer **"Save"**

#### Étape 4.4 : Configurer le Client Secret
1. Aller dans l'onglet **"Credentials"**
2. **Client secret** : `yansnet-client-test-01`
3. Cliquer **"Save"**

### 5. **Configuration des Scopes (Optionnel)**

1. Aller dans **Client Scopes**
2. Le scope `openid` doit être présent par défaut

---

## 🗄️ Configuration Base de Données

### 1. **PostgreSQL**

Créer la base de données :
```sql
CREATE DATABASE yansnet;
```

### 2. **Migration**

Exécuter le script de migration : `/database/migration/init_schema.sql`

---

## ⚙️ Configuration Application

### 1. **application.properties**

```properties
# Application
spring.application.name=auth
server.port=8085

# Keycloak OAuth2 Resource Server
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8080/realms/yansnet
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=http://localhost:8080/realms/yansnet/protocol/openid-connect/certs

# Keycloak Admin Client (pour créer les utilisateurs)
keycloak.server-url=http://localhost:8080
keycloak.realm=yansnet
keycloak.admin-client-id=admin-cli
keycloak.admin-username=admin
keycloak.admin-password=admin

# Keycloak Client (pour l'authentification)
keycloak.client-id=yansnet-client-test-01
keycloak.client-secret=yansnet-client-test-01

# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/yansnet
spring.datasource.username=postgres
spring.datasource.password=qwertyuiop
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
```

### 2. **Dépendances importantes**

```kotlin
dependencies {
    // Keycloak
    implementation("org.keycloak:keycloak-admin-client:23.0.4")
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:3.1.0")
    
    // Spring Security OAuth2
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    
    // Database
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")
}
```

---

## 🧪 Test des APIs

### 1. **Register**

```bash
curl -X POST http://localhost:8085/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@etsia.com",
    "password": "password123",
    "phoneNumber": "+1234567890"
  }'
```

**Réponse attendue :**
```json
{
  "userId": 123456,
  "email": "test@etsia.com",
  "accessToken": "eyJhbGciOiJSUzI1NiIsInR5cC...",
  "tokenType": "Bearer"
}
```

### 2. **Login**

```bash
curl -X POST http://localhost:8085/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@etsia.com",
    "password": "password123"
  }'
```

**Réponse attendue :**
```json
{
  "userId": 123456,
  "email": "test@etsia.com",
  "accessToken": "eyJhbGciOiJSUzI1NiIsInR5cC...",
  "tokenType": "Bearer"
}
```

### 3. **Logout**

```bash
curl -X POST http://localhost:8085/auth/logout \
  -H "Content-Type: application/json" \
  -d '{
    "userId": 123456
  }'
```

---

## ❗ Troubleshooting

### Erreur : "Account is not fully set up"

**Solution :** Vérifier que dans Keycloak :
1. Le client a **"Direct access grants enabled"** à `ON`
2. L'utilisateur est **"Enabled"** et **"Email verified"**

### Erreur : "invalid_client"

**Solution :** Vérifier :
1. Le `client-id` correspond exactement : `yansnet-client-test-01`
2. Le `client-secret` est correct : `yansnet-client-test-01`
3. Le client est configuré en mode **"Client authentication: ON"**

### Erreur : "User not found in local database"

**Solution :** 
1. Vérifier que PostgreSQL est démarré
2. Vérifier que la table `"user"` existe
3. L'utilisateur doit être créé via `/register` (pas directement dans Keycloak)

### Erreur de connexion Keycloak

**Solution :**
1. Vérifier que Keycloak est démarré sur `http://localhost:8080`
2. Vérifier que le realm `yansnet` existe
3. Vérifier les credentials admin dans `application.properties`

---

## 📝 Points importants

1. **Double persistance** : Utilisateurs stockés dans Keycloak ET PostgreSQL
2. **Tokens JWT** : Générés et validés par Keycloak uniquement
3. **Architecture DDD** : Domaine indépendant des frameworks
4. **Sécurité** : Mots de passe gérés par Keycloak (`KEYCLOAK_MANAGED`)

---

## 🔧 Développement

### Structure des packages

```
auth/
├── domain/
│   ├── model/User.java
│   ├── repository/UserRepository.java
│   └── service/AuthService.java
├── application/
│   └── service/AuthApplicationService.java
└── infrastructure/
    ├── config/
    │   ├── KeycloakConfig.java
    │   └── SecurityConfig.java
    ├── controller/AuthController.java
    ├── dto/
    ├── repository/
    └── service/KeycloakAuthService.java
```

### Démarrage rapide

1. Démarrer Keycloak (Docker)
2. Configurer le realm et client
3. Démarrer PostgreSQL
4. Exécuter les migrations
5. Lancer l'application : `./gradlew bootRun`

L'authentification est maintenant opérationnelle ! 🎉