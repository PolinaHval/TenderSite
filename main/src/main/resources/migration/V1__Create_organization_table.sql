CREATE TABLE organizations
(
    id             BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    unp            INTEGER   NOT NULL UNIQUE,
    full_name      VARCHAR   NOT NULL,
    short_name     VARCHAR   NOT NULL,
    legal_address  VARCHAR   NOT NULL,
    actual_address VARCHAR   NOT NULL
);