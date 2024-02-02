package com.ingela.revenuereportservice.models;

import com.ingela.revenuereportservice.models.dto.TotalValuePerWeekDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@SqlResultSetMapping(
        name = "TotalValueWeekMapping",
        classes = @ConstructorResult(
                targetClass = TotalValuePerWeekDto.class,
                columns = {
                        @ColumnResult(name = "totalValue", type = BigDecimal.class),
                        @ColumnResult(name = "week", type = Integer.class)
                }
        )
)
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Dummy.findTotalOrderValueByWeek",
                query = "SELECT " +
                        "EXTRACT(WEEK FROM orderDate) AS week, " +
                        "SUM(CAST(SPLIT_PART(REPLACE(grandTotalConvertedValue, ' ', ''), 'SEK', 1) AS NUMERIC)) AS totalValue " +
                        "FROM orders " +
                        "WHERE EXTRACT(YEAR FROM orderDate) = :year AND storename != 'Wholesale' " +
                        "GROUP BY week " +
                        "ORDER BY week",
                resultSetMapping = "TotalValueWeekMapping"
        ),
        @NamedNativeQuery(
                name = "Dummy.findTotalReturnValueByWeek",
                query = "SELECT " +
                        "EXTRACT(WEEK FROM createdAt) AS week, " +
                        "SUM(CAST(SPLIT_PART(REPLACE(REPLACE(REPLACE(grandTotalConvertedFormattedValue, ' ', ''), 'SEK', ''), ',', '.'), ',', 1) AS NUMERIC)) AS totalReturn " +
                        "FROM returns " +
                        "WHERE EXTRACT(YEAR FROM createdAt) = :year AND storename != 'Wholesale' " +
                        "GROUP BY week " +
                        "ORDER BY week",
                resultSetMapping = "TotalValueWeekMapping"
        )
})
@Setter
@Getter
@Entity
public class Dummy {
    @Id
    private String id;
}
