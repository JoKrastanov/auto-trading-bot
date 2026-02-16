package com.tradingbot.market.supportedcrypto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SupportedCryptoService {
    public List<String> getIds() {
        return List.of(SupportedCrypto.values()).stream().map(SupportedCrypto::getReferenceId)
                .collect(Collectors.toList());
    }

    public String getSymbolById(String id) {
        return Arrays.stream(SupportedCrypto.values())
                .filter(crypto -> crypto.getReferenceId().equals(id))
                .map(SupportedCrypto::getSymbol).findFirst().orElse(null);
    }
}
