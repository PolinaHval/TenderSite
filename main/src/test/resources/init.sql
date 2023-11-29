CREATE TABLE roles
(
    id   BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    role VARCHAR   NOT NULL UNIQUE
);
INSERT INTO roles (role)
VALUES ('admin');
INSERT INTO roles (role)
VALUES ('mainUser');
INSERT INTO roles (role)
VALUES ('user');

CREATE TABLE organizations
(
    id             BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    unp            INTEGER   NOT NULL UNIQUE,
    full_name      VARCHAR   NOT NULL,
    short_name     VARCHAR   NOT NULL,
    legal_address  VARCHAR   NOT NULL,
    actual_address VARCHAR   NOT NULL
);
INSERT INTO organizations (unp, full_name, short_name, legal_address, actual_address)
VALUES (111111111, 'Общество с ограниченной ответственностью "Tander"','OOO "Tander"', 'г. Минск', 'г. Минск');




