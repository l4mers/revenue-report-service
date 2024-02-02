package com.ingela.revenuereportservice.repository;

import com.ingela.revenuereportservice.models.Dummy;
import com.ingela.revenuereportservice.models.dto.TotalValuePerWeekDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Dummy, String> {
    @Query(nativeQuery = true, name = "Dummy.findTotalOrderValueByWeek")
    List<TotalValuePerWeekDto> findTotalOrderValueByWeek(Integer year);
    @Query(nativeQuery = true, name = "Dummy.findTotalReturnValueByWeek")
    List<TotalValuePerWeekDto> findTotalReturnValueByWeek(Integer year);

    @Query(nativeQuery = true, name = "Dummy.findTotalInvoiceValueByWeek")
    List<TotalValuePerWeekDto> findTotalInvoiceValueByWeek(Integer year);
}
