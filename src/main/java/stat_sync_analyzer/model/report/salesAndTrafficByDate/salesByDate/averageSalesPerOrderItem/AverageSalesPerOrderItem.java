package stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSalesPerOrderItem;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class AverageSalesPerOrderItem {
    private double amount;
    private String currencyCode;
}
