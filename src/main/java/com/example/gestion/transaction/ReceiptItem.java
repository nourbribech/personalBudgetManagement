package com.example.gestion.transaction;
import java.math.BigDecimal;
public record ReceiptItem( String description,
                           BigDecimal amount,
                           int quantity) {
}
