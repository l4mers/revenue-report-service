package com.ingela.revenuereportservice.controller;

import com.ingela.revenuereportservice.clientinterface.ReportClient;
import com.ingela.revenuereportservice.models.dto.TotalValuePerWeekDto;
import com.ingela.revenuereportservice.models.orders.OrdersDtoByWeek;
import com.ingela.revenuereportservice.models.returns.ReturnsDtoByWeek;
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
    public ResponseEntity<List<OrdersDtoByWeek>> getOrdersValuePerWeek(Integer startYear, Integer endYear) {
        return ResponseEntity.ok(reportService.findWeeklyRevenue(startYear, endYear));

    }
    @Override
    public ResponseEntity<List<ReturnsDtoByWeek>> getReturnsValuePerWeek(Integer startYear, Integer endYear) {
        return ResponseEntity.ok(reportService.findWeeklyReturns(startYear, endYear));
    }

    @Override
    public ResponseEntity<List<TotalValuePerWeekDto>> test() {
        return ResponseEntity.ok(reportService.test());
    }
}
