CREATE TABLE applications
(
    id              BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id INTEGER,
    tender_id       INTEGER,
    unit_price      VARCHAR   NOT NULL,
    total_cost      VARCHAR   NOT NULL


);