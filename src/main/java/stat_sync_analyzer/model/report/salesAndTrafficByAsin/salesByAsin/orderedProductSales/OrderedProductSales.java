package stat_sync_analyzer.model.report.salesAndTrafficByAsin.salesByAsin.orderedProductSales;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class OrderedProductSales {
    private double amount;
    private String currencyCode;
}
