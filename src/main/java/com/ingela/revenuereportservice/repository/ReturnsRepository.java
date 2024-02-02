package com.ingela.revenuereportservice.repository;

import com.ingela.revenuereportservice.models.orders.WeeklyRevenueProjection;
import com.ingela.revenuereportservice.models.returns.Returns;
import com.ingela.revenuereportservice.models.returns.WeeklyReturnsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public interface ReturnsRepository extends JpaRepository<Returns, String> {
    @Query(value = "SELECT " +
            "EXTRACT(WEEK FROM createdAt) AS week, " +
            "SUM(CAST(SPLIT_PART(REPLACE(REPLACE(REPLACE(grandTotalConvertedFormattedValue, ' ', ''), 'SEK', ''), ',', '.'), ',', 1) AS NUMERIC)) AS totalReturn " +
            "FROM returns " +
            "WHERE EXTRACT(YEAR FROM createdAt) BETWEEN :startYear AND :endYear AND storename != 'Wholesale' " +
            "GROUP BY week " +
            "ORDER BY week",
            nativeQuery = true)
    List<WeeklyReturnsProjection> findWeeklyReturns(@Param("startYear") int startYear, @Param("endYear") int endYear);
}
