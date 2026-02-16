package com.tradingbot.market.dtos;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CryptoSummary {
    private String referenceId;
    private String symbol;
    private String name;
    private String imageData;
    private BigDecimal latestPrice;
}
