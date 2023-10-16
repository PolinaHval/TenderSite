CREATE TABLE users
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id  BIGINT REFERENCES organizations (id),
    role_id          BIGINT REFERENCES roles (id),
    username        VARCHAR   NOT NULL UNIQUE,
    password        VARCHAR   NOT NULL,
    name            VARCHAR   NOT NULL,
    email           VARCHAR   NOT NULL UNIQUE,
    last_name       VARCHAR   NOT NULL,
    patronymic      VARCHAR   NOT NULL,
    phone           VARCHAR   NOT NULL,
    job_title       VARCHAR   NOT NULL
);
INSERT INTO users (organization_id, role_id , username,  password , name, email, last_name, patronymic, phone, job_title)
VALUES ((SELECT id
           FROM organizations
           WHERE id = 1), (SELECT id
                           FROM roles
                           WHERE id = 1), 'Polina','$2a$12$O8u7qZEY9C.Hop6Q7idPDOofFpxYKy5W2O6ijaQt5mNrzXRgdfvWK', 'Полина', 'polina@tander.ru', 'Хваль', 'Сергеевна','545454545', 'Оператор');
