package com.ingela.revenuereportservice.service;

import com.ingela.revenuereportservice.models.dto.TotalValuePerWeekDto;
import com.ingela.revenuereportservice.models.orders.OrdersDtoByWeek;
import com.ingela.revenuereportservice.models.orders.WeeklyRevenueProjection;
import com.ingela.revenuereportservice.models.returns.ReturnsDtoByWeek;
import com.ingela.revenuereportservice.models.returns.WeeklyReturnsProjection;
import com.ingela.revenuereportservice.repository.OrdersRepository;
import com.ingela.revenuereportservice.repository.ReportRepository;
import com.ingela.revenuereportservice.repository.ReturnsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final OrdersRepository ordersRepository;
    private final ReturnsRepository returnsRepository;
    private final ReportRepository reportRepository;

    private OrdersDtoByWeek mapWeeklyRevenueProjectionToOrdersDtoByWeek(WeeklyRevenueProjection weeklyRevenueProjection){
        return OrdersDtoByWeek.builder()
                .week(weeklyRevenueProjection.getWeek())
                .totalRevenue(weeklyRevenueProjection.getTotalRevenue())
                .build();
    }

    private ReturnsDtoByWeek mapWeeklyReturnsProjectionToReturnsDtoByWeek(WeeklyReturnsProjection weeklyReturnsProjection){
        return ReturnsDtoByWeek.builder()
                .week(weeklyReturnsProjection.getWeek())
                .totalReturn(weeklyReturnsProjection.getTotalReturn())
                .build();
    }
    public List<OrdersDtoByWeek> findWeeklyRevenue(Integer startYear, Integer endYear) {
        return ordersRepository.findWeeklyRevenue(
                        (startYear == null || startYear < 2016 || startYear > LocalDate.now().getYear()) ? 2016 : startYear,
                        (endYear == null || endYear > (startYear == null ? 2016 : startYear) || endYear > LocalDate.now().getYear()) ? LocalDate.now().getYear() : endYear
                ).stream()
                .map(this::mapWeeklyRevenueProjectionToOrdersDtoByWeek)
                .toList();
    }

    public List<ReturnsDtoByWeek> findWeeklyReturns(Integer startYear, Integer endYear) {

        return returnsRepository.findWeeklyReturns(
                        (startYear == null || startYear < 2016 || startYear > LocalDate.now().getYear()) ? 2016 : startYear,
                        (endYear == null || endYear > (startYear == null ? 2016 : startYear) || endYear > LocalDate.now().getYear()) ? LocalDate.now().getYear() : endYear
                ).stream()
                .map(this::mapWeeklyReturnsProjectionToReturnsDtoByWeek)
                .toList();
    }

    public List<TotalValuePerWeekDto> test() {
        return reportRepository.findTotalOrderValueByWeek();
    }
}
