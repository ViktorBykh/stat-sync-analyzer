package stat_sync_analyzer.controller;

import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.SalesAndTrafficByDate;
import stat_sync_analyzer.service.SalesAndTrafficByDateService;

@RequiredArgsConstructor
@RequestMapping("/data-by-date")
@RestController
public class SalesAndTrafficByDateController {
    private final SalesAndTrafficByDateService salesAndTrafficByDateService;

    @GetMapping
    public ResponseEntity<List<SalesAndTrafficByDate>> getSalesAndTrafficByAsin(
            @RequestParam(defaultValue = "0")
            @Parameter(description = "default number page is `0`") int pageNumber,
            @RequestParam(defaultValue = "3")
            @Parameter(description = "default count items is `3`") int pageCount,
            @RequestParam(required = false)
            @Parameter(description = "filter data by a `date` - format: `2024-02-14`")
            String date,
            @RequestParam(required = false)
            @Parameter(description = "filter data by `start date` for a date range - format: `2024-02-14`")
            String startDate,
            @RequestParam(required = false)
            @Parameter(description = "filter data by `end date` for a date range - format: `2024-02-14`")
            String endDate) {
        List<SalesAndTrafficByDate> result = salesAndTrafficByDateService
                .getSalesAndTrafficByDate(pageNumber, pageCount, date, startDate, endDate);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/update")
    public ResponseEntity<List<SalesAndTrafficByDate>> getSalesAndTrafficByAsin(
            @RequestParam(defaultValue = "0")
            @Parameter(description = "default number page is `0`") int pageNumber,
            @RequestParam(defaultValue = "10")
            @Parameter(description = "default count items is `10`") int pageCount) {
        List<SalesAndTrafficByDate> result = salesAndTrafficByDateService
                .updateSalesAndTrafficByDate(pageNumber, pageCount);
        return ResponseEntity.ok(result);
    }
}
