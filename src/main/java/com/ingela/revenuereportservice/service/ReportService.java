package com.ingela.revenuereportservice.service;

import com.ingela.revenuereportservice.models.dto.TotalValuePerWeekDto;
import com.ingela.revenuereportservice.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public List<TotalValuePerWeekDto> findWeeklyRevenue(Integer year) {
        return reportRepository.findTotalOrderValueByWeek(year);
    }

    public List<TotalValuePerWeekDto> findWeeklyReturns(Integer year) {
        return reportRepository.findTotalReturnValueByWeek(year);
    }

    public List<TotalValuePerWeekDto> findWeeklyInvoice(Integer year) {
        return reportRepository.findTotalInvoiceValueByWeek(year);
    }
}
