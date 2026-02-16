package com.tradingbot.market.repository;

import java.util.List;
import com.tradingbot.market.dtos.CryptoDetails;
import com.tradingbot.market.dtos.CryptoSummary;
import com.tradingbot.market.models.CryptoCurrency;
import com.tradingbot.market.models.CryptoImage;
import com.tradingbot.market.models.CryptoPrice;

public interface ICryptoRepository {
    void saveCrypto(CryptoCurrency crypto);

    void savePrice(CryptoPrice price);

    void saveImage(CryptoImage image);

    boolean cryptoHasImage(String referenceId);

    List<CryptoSummary> findAllCryptosSummary();

    CryptoDetails findCryptoById(String id);

    List<CryptoPrice> findPricesByCryptoId(String referenceId);
}
