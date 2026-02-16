package com.tradingbot.market.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tradingbot.market.CryptoService;
import com.tradingbot.market.dtos.CryptoSummary;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/crypto")
@RequiredArgsConstructor
public class CryptoController {
    private final CryptoService cryptoService;

    @GetMapping("/currencies")
    public ResponseEntity<List<CryptoSummary>> getCurrencies()
    {
        return ResponseEntity.ok(
            this.cryptoService.getCryptosSummary()
        );
    }    
    
}
