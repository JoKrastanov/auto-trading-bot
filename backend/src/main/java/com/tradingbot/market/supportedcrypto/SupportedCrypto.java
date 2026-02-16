package com.tradingbot.market.supportedcrypto;

public enum SupportedCrypto {
    BTC("btc", "630629f84e66ce0983f2cd4e"), // Bitcoin
    ETH("eth", "630629da4e66ce0983f2cd4d"), // Etherium
    SOL("sol", "632aef5962aa4a72545215d8"), // Solana
    USDT("ustd", "6306352b3290940c0e34eb1e"), // Tether
    XRP("xrp", "6307409a2e101367e7f9af85"), // XRP
    TRX("trx", "6307633f2e101367e7f9af87"), // TRX
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
