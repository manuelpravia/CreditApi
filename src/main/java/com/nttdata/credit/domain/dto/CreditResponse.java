package com.nttdata.credit.domain.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Value
public class CreditResponse {
    private String id;
    private String type;
    private BigDecimal amount;
    private LocalDateTime date;
    private List<String> customers;
}
