package stat_sync_analyzer.model.report.salesAndTrafficByAsin;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.salesByAsin.SalesByAsin;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.trafficByAsin.TrafficByAsin;

@Data
@Document(collection = "test_report")
public class SalesAndTrafficByAsin {
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
