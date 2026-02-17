package com.tradingbot.account.repository;

import java.math.BigDecimal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public Long createAccount(BigDecimal initialBalance) {
        String sql = """
            INSERT INTO account (balance)
            VALUES (?)
            RETURNING id
        """;

        return jdbcTemplate.queryForObject(
            sql,
            Long.class,
            initialBalance
        );
    }

    public void addBalance(Long accountId, BigDecimal deposit) {
        String updateBalance = """
            UPDATE account
            SET balance = balance + ?
            WHERE id = ?
        """;

        jdbcTemplate.update(updateBalance, deposit, accountId);
    }
    
    public void removeBalance(Long accountId, BigDecimal deposit) {
        String updateBalance = """
            UPDATE account
            SET balance = balance - ?
            WHERE id = ?
        """;

        jdbcTemplate.update(updateBalance, deposit, accountId);
    }

    public BigDecimal getBalance(Long accountId) {
        String sql = """
            SELECT balance
            FROM account
            WHERE id = ?
        """;

        return jdbcTemplate.queryForObject(
            sql,
            BigDecimal.class,
            accountId
        );
    }

    @Transactional
    public void buyCrypto(
        Long accountId,
        String cryptoId,
        BigDecimal amount,
        BigDecimal investedUsd
    ) {
        // 1. Deduct balance
        String updateBalance = """
            UPDATE account
            SET balance = balance - ?
            WHERE id = ?
        """;

        jdbcTemplate.update(updateBalance, investedUsd, accountId);

        // 2. Insert or update holding
        String upsertHolding = """
            INSERT INTO account_holding (
                account_id,
                crypto_id,
                amount,
                total_invested_amount
            )
            VALUES (?, ?, ?, ?)
            ON CONFLICT (account_id, crypto_id)
            DO UPDATE SET
                amount = account_holding.amount + EXCLUDED.amount,
                total_invested_amount =
                    account_holding.total_invested_amount + EXCLUDED.total_invested_amount
        """;

        jdbcTemplate.update(
            upsertHolding,
            accountId,
            cryptoId,
            amount,
            investedUsd
        );
    }

    @Transactional
    public void sellCrypto(
        Long accountId,
        String cryptoId,
        BigDecimal amount,
        BigDecimal receivedUsd
    ) {
        // 1. Increase balance
        String updateBalance = """
            UPDATE account
            SET balance = balance + ?
            WHERE id = ?
        """;

        jdbcTemplate.update(updateBalance, receivedUsd, accountId);

        // 2. Reduce holding
        String updateHolding = """
            UPDATE account_holding
            SET amount = amount - ?
            WHERE account_id = ? AND crypto_id = ?
        """;

        jdbcTemplate.update(updateHolding, amount, accountId, cryptoId);
    }
}
