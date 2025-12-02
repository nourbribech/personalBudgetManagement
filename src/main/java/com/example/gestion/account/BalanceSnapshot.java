package com.example.gestion.account;
import java.util.Currency;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public record BalanceSnapshot(String accountId,
                              LocalDateTime timestamp,
                              BigDecimal balance,
                              BigDecimal availableBalance,
                              Currency currency)
{

}
