package com.ingela.revenuereportservice.repository;

import com.ingela.revenuereportservice.models.orders.Orders;
import com.ingela.revenuereportservice.models.orders.WeeklyRevenueProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {

    @Query(value = "SELECT " +
            "EXTRACT(WEEK FROM orderDate) AS week, " +
            "SUM(CAST(SPLIT_PART(REPLACE(grandTotalConvertedValue, ' ', ''), 'SEK', 1) AS NUMERIC)) AS totalRevenue " +
            "FROM orders " +
            "WHERE EXTRACT(YEAR FROM orderDate) BETWEEN :startYear AND :endYear AND storename != 'Wholesale' " +
            "GROUP BY week " +
            "ORDER BY week",
            nativeQuery = true)
    List<WeeklyRevenueProjection> findWeeklyRevenue(Integer startYear, Integer endYear);
}
