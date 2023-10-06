CREATE TABLE users
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id INTEGER,
    role_id         INTEGER,
    username        VARCHAR   NOT NULL UNIQUE,
    password        VARCHAR   NOT NULL,
    name            VARCHAR   NOT NULL,
    email           VARCHAR   NOT NULL UNIQUE,
    last_name       VARCHAR   NOT NULL,
    patronymic      VARCHAR   NOT NULL,
    phone           VARCHAR   NOT NULL,
    job_title       VARCHAR   NOT NULL
);
