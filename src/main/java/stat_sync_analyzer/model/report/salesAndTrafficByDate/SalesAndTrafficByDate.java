package stat_sync_analyzer.model.report.salesAndTrafficByDate;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.SalesByDate;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.trafficByDate.TrafficByDate;

@Data
@Document(collection = "test_report")
public class SalesAndTrafficByDate {
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
