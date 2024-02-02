package com.ingela.revenuereportservice.controller;

import com.ingela.revenuereportservice.clientinterface.ReportClient;
import com.ingela.revenuereportservice.models.dto.TotalValuePerWeekDto;
import com.ingela.revenuereportservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ReportController implements ReportClient {
    final private ReportService reportService;

    @Override
    public ResponseEntity<List<TotalValuePerWeekDto>> getOrdersValuePerWeek(Integer year) {
        return ResponseEntity.ok(reportService.findWeeklyRevenue(year));

    }
    @Override
    public ResponseEntity<List<TotalValuePerWeekDto>> getReturnsValuePerWeek(Integer year) {
        return ResponseEntity.ok(reportService.findWeeklyReturns(year));
    }
    @Override
    public ResponseEntity<List<TotalValuePerWeekDto>> getInvoiceValuePerWeek(Integer year) {
        return ResponseEntity.ok(reportService.findWeeklyInvoice(year));
    }
}
