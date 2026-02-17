package com.tradingbot.account.models;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountHolding {
    Long id;
    Long accountId;
    String cryptoId;
    BigDecimal amount;
    BigDecimal totalInvestedAmount;
}
