package stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSellingPrice;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class AverageSellingPrice {
    private double amount;
    private String currencyCode;
}
