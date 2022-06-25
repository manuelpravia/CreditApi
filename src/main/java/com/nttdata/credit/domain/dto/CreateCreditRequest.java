package com.nttdata.credit.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateCreditRequest {

    @NotBlank
    private String type;
    @NotNull
    private BigDecimal amount;
    private List<String> customers;
}
