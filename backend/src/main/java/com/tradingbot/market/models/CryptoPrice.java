package com.tradingbot.market.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoPrice {
    private BigDecimal price;
    private LocalDateTime calculationTimeStamp;
    private String referenceId;
}
