package com.tradingbot.market;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tradingbot.market.dtos.CryptoSummary;
import com.tradingbot.market.repository.CryptoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoService {
    private final CryptoRepository cryptoRepository;

    public List<CryptoSummary> getCryptosSummary()
    {
        return this.cryptoRepository.findAllCryptosSummary();
    }
}
