-- Account table
CREATE TABLE account (
    id BIGSERIAL PRIMARY KEY,
    balance NUMERIC(38, 8) NOT NULL DEFAULT 0
);

-- AccountHolding table
CREATE TABLE account_holding (
    id BIGSERIAL PRIMARY KEY,
    account_id BIGINT NOT NULL,
    crypto_id VARCHAR(50) NOT NULL,
    amount NUMERIC(38, 8) NOT NULL DEFAULT 0,
    total_invested_amount NUMERIC(38, 8) NOT NULL DEFAULT 0,

    CONSTRAINT fk_account
        FOREIGN KEY (account_id)
        REFERENCES account(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_crypto
        FOREIGN KEY (crypto_id)
        REFERENCES crypto_currency(reference_id)
        ON DELETE CASCADE,

    CONSTRAINT unique_account_crypto
        UNIQUE (account_id, crypto_id)
);
