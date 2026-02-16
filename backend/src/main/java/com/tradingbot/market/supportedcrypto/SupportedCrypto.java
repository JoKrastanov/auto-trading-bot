package com.tradingbot.market.supportedcrypto;

public enum SupportedCrypto {
    BTC("btc", "630629f84e66ce0983f2cd4e"), // Bitcoin
    ETH("eth", "630629da4e66ce0983f2cd4d"), // Etherium
    SOL("sol", "632aef5962aa4a72545215d8"), // Solana
    DOGE("doge", "6307400a2e101367e7f9af81"), // DogeCoin
    PEPE("pepe", "675ed4d47a103759e094ec4a"); // Pepe

    private final String symbol;
    private final String referenceId;

    SupportedCrypto(String symbol, String referenceId) {
        this.symbol = symbol;
        this.referenceId = referenceId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public String getSymbol() {
        return symbol;
    }
}
