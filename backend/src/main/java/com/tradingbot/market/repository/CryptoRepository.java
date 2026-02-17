package com.tradingbot.market.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tradingbot.market.dtos.CryptoDetails;
import com.tradingbot.market.dtos.CryptoSummary;
import com.tradingbot.market.models.CryptoCurrency;
import com.tradingbot.market.models.CryptoImage;
import com.tradingbot.market.models.CryptoPrice;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CryptoRepository {

    private final JdbcTemplate jdbcTemplate;

    public void saveCrypto(CryptoCurrency crypto) {
        String sql = """
                INSERT INTO crypto_currency
                (reference_id, name, symbol, max_supply, circulating_supply,
                 market_cap_usd, latest_price_usd, percentage_price_change_last_hour,
                 percentage_price_change_last_day, percentage_price_change_last_week)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                ON CONFLICT (reference_id) DO UPDATE SET
                    name = EXCLUDED.name,
                    symbol = EXCLUDED.symbol,
                    max_supply = EXCLUDED.max_supply,
                    circulating_supply = EXCLUDED.circulating_supply,
                    market_cap_usd = EXCLUDED.market_cap_usd,
                    latest_price_usd = EXCLUDED.latest_price_usd,
                    percentage_price_change_last_hour = EXCLUDED.percentage_price_change_last_hour,
                    percentage_price_change_last_day = EXCLUDED.percentage_price_change_last_day,
                    percentage_price_change_last_week = EXCLUDED.percentage_price_change_last_week
                """;

        jdbcTemplate.update(sql, crypto.getReferenceId(), crypto.getName(), crypto.getSymbol(),
                crypto.getMaxSupply(), crypto.getCirculatingSupply(), crypto.getMarketCapUsd(),
                crypto.getLatestPriceUsd(), crypto.getPercentagePriceChangeLastHour(),
                crypto.getPercentagePriceChangeLastDay(),
                crypto.getPercentagePriceChangeLastWeek());
    }

    public void savePrice(CryptoPrice price) {
        String sql = """
                INSERT INTO crypto_price
                (reference_id, price, calculation_timestamp)
                VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(sql, price.getReferenceId(), price.getPrice(),
                Timestamp.valueOf(price.getCalculationTimeStamp()));
    }

    public void saveImage(CryptoImage image) {
        String sql = """
                INSERT INTO crypto_image
                (reference_id, image_data)
                VALUES (?, ?)
                """;

        jdbcTemplate.update(sql, image.getReferenceId(), image.getImageData());
    }

    public boolean cryptoHasImage(String referenceId) {
        String sql = "SELECT EXISTS (SELECT 1 FROM crypto_image WHERE reference_id = ?)";
        return jdbcTemplate.queryForObject(sql, Boolean.class, referenceId);
    }

    public List<CryptoSummary> findAllCryptosSummary() {
        String sql = """
                SELECT c.reference_id, c.name, c.symbol, c.latest_price_usd, ci.image_data
                FROM crypto_currency as c inner join crypto_image as ci
                ON c.reference_id = ci.reference_id
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            CryptoSummary s = new CryptoSummary();
            s.setReferenceId(rs.getString("reference_id"));
            s.setName(rs.getString("name"));
            s.setSymbol(rs.getString("symbol"));
            s.setLatestPrice(rs.getBigDecimal("latest_price_usd"));
            s.setImageData(rs.getString("image_data"));
            return s;
        });
    }

    public CryptoDetails findCryptoById(String id) {
        String sql = """
                SELECT
                    c.reference_id,
                    c.name,
                    c.symbol,
                    c.max_supply,
                    c.circulating_supply,
                    c.market_cap_usd,
                    c.latest_price_usd,
                    c.percentage_price_change_last_hour,
                    c.percentage_price_change_last_day,
                    c.percentage_price_change_last_week,
                    ci.image_data
                FROM crypto_currency c
                LEFT JOIN crypto_image ci
                    ON c.reference_id = ci.reference_id
                WHERE c.reference_id = ?
                """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            CryptoDetails details = new CryptoDetails();
            details.setReferenceId(rs.getString("reference_id"));
            details.setName(rs.getString("name"));
            details.setSymbol(rs.getString("symbol"));
            details.setMaxSupply(rs.getBigDecimal("max_supply"));
            details.setCirculatingSupply(rs.getBigDecimal("circulating_supply"));
            details.setMarketCapUsd(rs.getBigDecimal("market_cap_usd"));
            details.setLatestPriceUsd(rs.getBigDecimal("latest_price_usd"));

            details.setPercentagePriceChangeLastHour(
                    rs.getBigDecimal("percentage_price_change_last_hour"));
            details.setPercentagePriceChangeLastDay(
                    rs.getBigDecimal("percentage_price_change_last_day"));
            details.setPercentagePriceChangeLastWeek(
                    rs.getBigDecimal("percentage_price_change_last_week"));

            details.setImageData(rs.getString("image_data"));

            return details;
        }, id);
    }
}
