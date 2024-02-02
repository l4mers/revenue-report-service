package com.ingela.revenuereportservice.clientinterface;

import com.ingela.revenuereportservice.models.dto.TotalValuePerWeekDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/report")
public interface ReportClient {

    @Operation(
            summary = "Fetches revenues value by week for the given year",
            description = "Fetches weekly values from orders by week by given year",
            parameters =
                    @Parameter(
                            name = "year",
                            description = "Given year to fetch weekly values of that year",
                            example = "2023",
                            in = ParameterIn.QUERY)
    )
    @GetMapping("/orders")
    ResponseEntity<List<TotalValuePerWeekDto>> getOrdersValuePerWeek(
            @RequestParam Integer year
    );

    @Operation(
            summary = "Fetches returns value by week for the given year",
            description = "Fetches weekly values from returns by week by given year",
            parameters =
            @Parameter(
                    name = "year",
                    description = "Given year to fetch weekly values of that year",
                    example = "2023",
                    in = ParameterIn.QUERY)
    )
    @GetMapping("/returns")
    ResponseEntity<List<TotalValuePerWeekDto>> getReturnsValuePerWeek(
            @RequestParam Integer year
    );

    @Operation(
            summary = "Fetches invoices value by week for the given year",
            description = "Fetches weekly values from invoices by week by given year",
            parameters =
            @Parameter(
                    name = "year",
                    description = "Given year to fetch weekly values of that year",
                    example = "2023",
                    in = ParameterIn.QUERY)
    )
    @GetMapping("/invoices")
    ResponseEntity<List<TotalValuePerWeekDto>> getInvoiceValuePerWeek(
            @RequestParam(required = false) Integer year
    );
}
