package com.tradingbot.market.cryptoapiclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoApiClient {

    private final RestTemplate restTemplate;

    @Value("${application.crypto-api-key}")
    private String apiKey;

    @Value("${application.crypto-api-url}")
    private String baseUrl;

    public CryptoApiAssetResponse fetchAssetById(String id) {
        String url = this.baseUrl + "/market-data/assets/by-id/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", this.apiKey);
        headers.setAccept(MediaType.parseMediaTypes("application/json"));

        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<CryptoApiAssetResponse> response = restTemplate.exchange(url,
                    HttpMethod.GET, request, CryptoApiAssetResponse.class);

            return response.getBody();

        } catch (Exception ex) {
            log.error("Failed to fetch crypto asset for symbol {}", id, ex);
            throw ex;
        }
    }
}
