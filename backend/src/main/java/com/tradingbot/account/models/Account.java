package com.tradingbot.account.models;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Account {
    Long id;
    BigDecimal balance;
}
