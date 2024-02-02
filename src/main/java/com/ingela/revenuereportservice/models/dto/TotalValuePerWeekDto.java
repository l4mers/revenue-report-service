package com.ingela.revenuereportservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TotalValuePerWeekDto {
    private BigDecimal totalValue;
    private Integer week;
}
