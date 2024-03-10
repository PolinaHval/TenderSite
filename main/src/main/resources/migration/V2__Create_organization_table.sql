CREATE TABLE organizations
(
    id             BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    unp            INTEGER   NOT NULL UNIQUE,
    full_name      VARCHAR   NOT NULL,
    short_name     VARCHAR   NOT NULL,
    legal_address  VARCHAR   NOT NULL,
    actual_address VARCHAR   NOT NULL,
    activity VARCHAR   NOT NULL
);
INSERT INTO organizations (unp, full_name, short_name, legal_address, actual_address, activity)
VALUES (111111111, 'Общество с ограниченной ответственностью "Tander"','OOO "Tander"', 'г. Минск', 'г. Минск',
        'legalEntity');

INSERT INTO organizations (unp, full_name, short_name, legal_address, actual_address, activity)
VALUES (222222222, 'Общество с ограниченной ответственностью "Ромашка"','OOO "Ромашка"', 'г. Минск', 'г. Минск',
        'legalEntity');