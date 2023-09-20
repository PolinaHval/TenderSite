CREATE TABLE applications
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id INTEGER,
    tender_id       INTEGER,
    unit_Price      VARCHAR   NOT NULL,
    total_Cost      VARCHAR   NOT NULL


);