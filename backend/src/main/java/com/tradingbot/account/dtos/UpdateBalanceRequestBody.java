package com.tradingbot.account.dtos;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UpdateBalanceRequestBody {
    private BigDecimal amount;
}
