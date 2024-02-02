package com.ingela.revenuereportservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class TotalValuePerYearDto {
    private Integer year;
    private List<TotalValuePerWeekDto> orders;
    private List<TotalValuePerWeekDto> returns;
    private List<TotalValuePerWeekDto> invoices;
}
