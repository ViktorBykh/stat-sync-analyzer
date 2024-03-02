package stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSalesPerOrderItemB2B;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class AverageSalesPerOrderItemB2B {
    private double amount;
    private String currencyCode;
}
