CREATE TABLE organizations
(
    id             BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    unp            INTEGER   NOT NULL UNIQUE,
    full_Name      VARCHAR   NOT NULL,
    short_Name     VARCHAR   NOT NULL,
    legal_Address  VARCHAR   NOT NULL,
    actual_Address VARCHAR   NOT NULL
);


INSERT INTO organizations (unp, full_Name, short_Name, legal_Address, actual_Address)
VALUES ('123456789', 'Общество с ограниченной ответственностью "Ромашка', 'ООО "Ромашка"', 'г. Минск, Брикета, д. 5',
        'г. Минск, Брикета, д. 5');