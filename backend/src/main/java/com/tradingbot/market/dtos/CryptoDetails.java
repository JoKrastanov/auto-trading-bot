package com.tradingbot.market.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CryptoDetails {
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
    private String imageData;
}
