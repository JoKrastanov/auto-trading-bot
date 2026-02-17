package com.tradingbot.account.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.tradingbot.account.dtos.UpdateBalanceRequestBody;
import com.tradingbot.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Long createAccount()
    {
        return this.accountRepository.createAccount(BigDecimal.ZERO);
    }

    public BigDecimal getBalance(Long accountId)
    {
        return this.accountRepository.getBalance(accountId);
    }

    public void deposit(Long accountId, UpdateBalanceRequestBody body) {
        BigDecimal amount = body.getAmount();
        this.accountRepository.addBalance(accountId, amount);
    }

    public void withdraw(Long accountId, UpdateBalanceRequestBody body) {
        BigDecimal amount = body.getAmount();
        this.accountRepository.removeBalance(accountId, amount);
    }
}
