CREATE TABLE tenders
(
    id                  BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id     INTEGER,
    subject             VARCHAR   NOT NULL,
    short_description   VARCHAR   NOT NULL,
    valuta              VARCHAR   NOT NULL,
    amount              VARCHAR   NOT NULL,
    unit_of_measurement VARCHAR   NOT NULL,
    unit_price          VARCHAR   NOT NULL,
    total_cost          VARCHAR   NOT NULL,
    terms_of_payment    VARCHAR   NOT NULL,
    delivery_conditions VARCHAR   NOT NULL,
    status BOOLEAN NOT NULL,
    status_without_winner BOOLEAN NOT NULL,
    comments VARCHAR,
    price_visibility VARCHAR   NOT NULL,
    withdrawal_of_application VARCHAR   NOT NULL

);