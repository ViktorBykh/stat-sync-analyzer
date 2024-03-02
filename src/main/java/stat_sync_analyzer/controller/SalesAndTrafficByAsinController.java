package stat_sync_analyzer.controller;

import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.SalesAndTrafficByAsin;
import stat_sync_analyzer.service.SalesAndTrafficByAsinService;

@RequiredArgsConstructor
@RequestMapping("/data-by-asin")
@RestController
public class SalesAndTrafficByAsinController {
    private final SalesAndTrafficByAsinService salesAndTrafficByAsinService;

    @GetMapping
    public ResponseEntity<List<SalesAndTrafficByAsin>> getSalesAndTrafficByAsin(
            @RequestParam(defaultValue = "0")
            @Parameter(description = "default number page is `0`") int pageNumber,
            @RequestParam(defaultValue = "3")
            @Parameter(description = "default count items is `3`") int pageCount,
            @RequestParam(required = false)
            @Parameter(description = "filter data by `ASIN`")
            String asin,
            @RequestParam(required = false)
            @Parameter(description = "filter data by the list of`ASINs`")
            List<String> asins) {
        List<SalesAndTrafficByAsin> result = salesAndTrafficByAsinService
                .getSalesAndTrafficByAsin(pageNumber, pageCount, asin, asins);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/update")
    public ResponseEntity<List<SalesAndTrafficByAsin>> updateSalesAndTrafficByAsin(
            @RequestParam(defaultValue = "0")
            @Parameter(description = "default number page is `0`") int pageNumber,
            @RequestParam(defaultValue = "10")
            @Parameter(description = "default count items is `10`") int pageCount) {
        List<SalesAndTrafficByAsin> result = salesAndTrafficByAsinService
                .updateSalesAndTrafficByAsin(pageNumber, pageCount);
        return ResponseEntity.ok(result);
    }
}
