package com.tradingbot.market;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tradingbot.market.cryptoapiclient.CryptoApiAssetResponse;
import com.tradingbot.market.cryptoapiclient.CryptoApiAssetResponse.Item;
import com.tradingbot.market.models.CryptoCurrency;
import com.tradingbot.market.models.CryptoImage;
import com.tradingbot.market.models.CryptoPrice;
import com.tradingbot.market.cryptoapiclient.CryptoApiClient;
import com.tradingbot.market.repository.CryptoRepository;
import com.tradingbot.market.supportedcrypto.SupportedCryptoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CryptoPriceSyncService {

    private final SupportedCryptoService supportedCryptoService;
    private final CryptoApiClient cryptoApiClient;
    private final CryptoRepository cryptoRepository;

    // Sync crypto prices every 5 minutes
    @Scheduled(fixedRate = 300_000)
    public void syncCryptoPrices() {
        log.info("Starting crypto price sync task");
        List<String> ids = this.supportedCryptoService.getIds();

        ids.forEach(id -> {
            String symbol = this.supportedCryptoService.getSymbolById(id);

            log.info(String.format("Syncing price of %s", symbol));

            CryptoApiAssetResponse response = this.cryptoApiClient.fetchAssetById(id);

            Item responseItem = response.getData().getItem();

            CryptoCurrency currency = this.createCurrency(responseItem);
            this.cryptoRepository.saveCrypto(currency);

            CryptoPrice price = this.createPrice(responseItem);
            this.cryptoRepository.savePrice(price);

            // Crypto Image is saved only once
            if (!this.cryptoRepository.cryptoHasImage(id)) {
                CryptoImage image = this.createImage(responseItem);
                this.cryptoRepository.saveImage(image);
            }

            log.info(String.format("Synced price of %s successfully", symbol));
        });
    }

    private CryptoCurrency createCurrency(Item cryptoItem) {
        return new CryptoCurrency(cryptoItem.getReferenceId(), cryptoItem.getName(),
                cryptoItem.getSymbol(), cryptoItem.getSpecificData().getMaxSupply(),
                cryptoItem.getSpecificData().getCirculatingSupply(),
                cryptoItem.getSpecificData().getMarketCapUsd(),
                cryptoItem.getLatestRate().getAmount(),
                LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(cryptoItem.getLatestRate().getCalculationTimestamp()),
                        ZoneId.systemDefault()),
                cryptoItem.getSpecificData().getPercentagePriceChangeLastHour(),
                cryptoItem.getSpecificData().getPercentagePriceChangeLastDay(),
                cryptoItem.getSpecificData().getPercentagePriceChangeLastWeek());
    }

    private CryptoPrice createPrice(Item cryptoItem) {
        return new CryptoPrice(cryptoItem.getLatestRate().getAmount(),
                LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(cryptoItem.getLatestRate().getCalculationTimestamp()),
                        ZoneId.systemDefault()),
                cryptoItem.getReferenceId());
    }

    private CryptoImage createImage(Item cryptoItem) {
        return new CryptoImage(cryptoItem.getReferenceId(), cryptoItem.getLogo().getImageData());
    }
}
