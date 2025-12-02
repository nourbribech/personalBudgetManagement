package com.example.gestion.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
public record Receipt(String receiptId,
                      LocalDate date,
                      String merchant,
                      BigDecimal totalAmount,
                      ArrayList<ReceiptItem> items)
{

}
