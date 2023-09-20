CREATE TABLE tenders
(
    id                  BIGSERIAL NOT NULL UNIQUE PRIMARY KEY,
    organization_id     INTEGER,
    subject             VARCHAR   NOT NULL,
    short_Description   VARCHAR   NOT NULL,
    valuta              VARCHAR   NOT NULL,
    amount              VARCHAR   NOT NULL,
    unit_Of_Measurement VARCHAR   NOT NULL,
    unit_Price          VARCHAR   NOT NULL,
    total_Cost          VARCHAR   NOT NULL,
    terms_Of_Payment    VARCHAR   NOT NULL,
    delivery_Conditions VARCHAR   NOT NULL
);