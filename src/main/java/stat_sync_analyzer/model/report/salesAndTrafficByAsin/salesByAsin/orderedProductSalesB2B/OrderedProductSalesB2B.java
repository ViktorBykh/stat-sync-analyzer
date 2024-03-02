package stat_sync_analyzer.model.report.salesAndTrafficByAsin.salesByAsin.orderedProductSalesB2B;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class OrderedProductSalesB2B {
    private int amount;
    private String currencyCode;
}
