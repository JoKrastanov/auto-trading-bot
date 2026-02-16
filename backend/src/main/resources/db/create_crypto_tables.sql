-- CryptoCurrency table
CREATE TABLE crypto_currency (
    reference_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    symbol VARCHAR(10) NOT NULL UNIQUE,
    max_supply NUMERIC(38, 8),
    circulating_supply NUMERIC(38, 8),
    market_cap_usd NUMERIC(38, 8),
    latest_price_usd NUMERIC(38, 8),
    percentage_price_change_last_hour NUMERIC(10, 6),
    percentage_price_change_last_day NUMERIC(10, 6),
    percentage_price_change_last_week NUMERIC(10, 6)
);

-- CryptoImage table
CREATE TABLE crypto_image (
    reference_id VARCHAR(50) NOT NULL REFERENCES crypto_currency(reference_id),
    image_data TEXT NOT NULL
);

-- CryptoPrice table
CREATE TABLE crypto_price (
    id SERIAL PRIMARY KEY,
    reference_id VARCHAR(50) NOT NULL REFERENCES crypto_currency(reference_id),
    price NUMERIC(38, 8) NOT NULL,
    calculation_timestamp TIMESTAMP NOT NULL,
);