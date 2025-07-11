-- Table de mapping entre les IDs internes et les UUIDs Keycloak
CREATE TABLE keycloak_user_mapping
(
    internal_user_id INT PRIMARY KEY,
    keycloak_user_id VARCHAR(36) UNIQUE NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (internal_user_id) REFERENCES "users" (id) ON DELETE CASCADE
);

-- Index pour optimiser les recherches
CREATE UNIQUE INDEX idx_keycloak_user_mapping_keycloak_id ON keycloak_user_mapping (keycloak_user_id);
CREATE INDEX idx_keycloak_user_mapping_internal_id ON keycloak_user_mapping (internal_user_id);

-- Séquence pour générer les IDs internes de manière séquentielle
CREATE SEQUENCE user_id_seq START WITH 1 INCREMENT BY 1;