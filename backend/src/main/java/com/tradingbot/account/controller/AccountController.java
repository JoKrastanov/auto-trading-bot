package com.tradingbot.account.controller;

import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tradingbot.account.dtos.UpdateBalanceRequestBody;
import com.tradingbot.account.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Long> createAccount() {
        return ResponseEntity.ok(this.accountService.createAccount());
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok(this.accountService.getBalance(id));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable Long id,
            @RequestBody UpdateBalanceRequestBody body) {
        this.accountService.deposit(id, body);
        return ResponseEntity.ok("Deposited funds");
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable Long id,
            @RequestBody UpdateBalanceRequestBody body) {
        this.accountService.withdraw(id, body);
        return ResponseEntity.ok("Withdrawn funds");
    }
}
