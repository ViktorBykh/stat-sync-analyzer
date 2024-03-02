package stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSellingPriceB2B;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class AverageSellingPriceB2B {
    private double amount;
    private String currencyCode;
}
