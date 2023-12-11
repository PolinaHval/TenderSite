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
INSERT INTO organizations (unp, full_name, short_name, legal_address, actual_address)
VALUES (222222222, 'Общество с ограниченной ответственностью "Ромашка"','OOO "Ромашка"', 'г. Минск', 'г. Минск');

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
                         WHERE id = 1), 'Polina','$2a$12$O8u7qZEY9C.Hop6Q7idPDOofFpxYKy5W2O6ijaQt5mNrzXRgdfvWK',
        'Полина', 'polina@tander.ru', 'Хваль', 'Сергеевна','545454545', 'Оператор');
INSERT INTO users (organization_id, role_id , username,  password , name, email, last_name, patronymic, phone, job_title)
VALUES ((SELECT id
         FROM organizations
         WHERE id = 1), (SELECT id
                         FROM roles
                         WHERE id = 2), 'Alina','$2a$12$O8u7qZEY9C.Hop6Q7idPDOofFpxYKy5W2O6ijaQt5mNrzXRgdfvWK', 'Алина',
        'alina@tander.ru', 'Иванова', 'Сергеевна','5454545785', 'Оператор');

CREATE TABLE tenders
(
    id                  BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id     BIGINT REFERENCES organizations (id),
    subject             VARCHAR   NOT NULL,
    short_description   VARCHAR   NOT NULL,
    valuta              VARCHAR   NOT NULL,
    amount              VARCHAR   NOT NULL,
    unit_of_measurement VARCHAR   NOT NULL,
    unit_price          VARCHAR   NOT NULL,
    total_cost          VARCHAR   NOT NULL,
    terms_of_payment    VARCHAR   NOT NULL,
    delivery_conditions VARCHAR   NOT NULL
);

INSERT INTO tenders (organization_id, subject, short_description, valuta, amount, unit_of_measurement, unit_price,
                     total_cost, terms_of_payment, delivery_conditions)
VALUES ((SELECT id
         FROM organizations
         WHERE id = 1 ),'Яблоки','Яблоки', 'BYN', 2, 'кг', 5, 10, 'отсрочка','отсрочка');

CREATE TABLE applications
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id INTEGER,
    tender_id       INTEGER,
    unit_price      VARCHAR   NOT NULL,
    total_cost      VARCHAR   NOT NULL
);

INSERT INTO applications (organization_id, tender_id, unit_price, total_cost)
VALUES ((SELECT id
    FROM organizations
    WHERE id = 1 ), (SELECT id
                    FROM tenders
                    WHERE id = 1 ), 2, 10);



CREATE TABLE victories
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id INTEGER,
    tender_id       INTEGER
);

INSERT INTO victories (organization_id, tender_id)
VALUES ((SELECT id
          FROM organizations
          WHERE id = 1 ),(SELECT id FROM tenders
                                    WHERE id = 1 ));
