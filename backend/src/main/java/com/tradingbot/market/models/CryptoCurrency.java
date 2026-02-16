package com.tradingbot.market.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrency {
    private String referenceId;
    private String name;
    private String symbol;
    private BigDecimal maxSupply;
    private BigDecimal circulatingSupply;
    private BigDecimal marketCapUsd;
    private BigDecimal latestPriceUsd;
    private LocalDateTime lastUpdate;
    private BigDecimal percentagePriceChangeLastHour;
    private BigDecimal percentagePriceChangeLastDay;
    private BigDecimal percentagePriceChangeLastWeek;
}
