package com.tradingbot.market.cryptoapiclient;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CryptoApiAssetResponse {

    private String apiVersion;
    private String requestId;
    private DataWrapper data;

    @lombok.Data
    public static class DataWrapper {
        private Item item;
    }

    @lombok.Data
    public static class Item {
        private LatestRate latestRate;
        private Logo logo;
        private String name;
        private String symbol;
        private String referenceId;
        private SpecificData specificData;
    }

    @lombok.Data
    public static class LatestRate {
        private BigDecimal amount;
        private long calculationTimestamp;
    }

    @lombok.Data
    public static class Logo {
        private String encoding;
        private String imageData;
        private String mimeType;
    }

    @lombok.Data
    public static class SpecificData {
        @JsonProperty("1HourPriceChangeInPercentage")
        private BigDecimal percentagePriceChangeLastHour;

        @JsonProperty("1WeekPriceChangeInPercentage")
        private BigDecimal percentagePriceChangeLastWeek;

        @JsonProperty("24HoursPriceChangeInPercentage")
        private BigDecimal percentagePriceChangeLastDay;

        @JsonProperty("marketCapInUSD")
        private BigDecimal marketCapUsd;

        private BigDecimal circulatingSupply;

        private BigDecimal maxSupply;
    }
}

