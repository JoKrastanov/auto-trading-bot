package com.tradingbot.market.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoImage {
    private String referenceId;
    private String imageData;
}
