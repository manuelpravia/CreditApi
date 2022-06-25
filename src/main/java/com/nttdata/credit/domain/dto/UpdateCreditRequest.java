package com.nttdata.credit.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UpdateCreditRequest {

    private String type;
    private BigDecimal amount;
    private LocalDateTime date;
    private List<String> customers;
}
