package stat_sync_analyzer.model.report;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import stat_sync_analyzer.model.report.reportSpecification.ReportSpecification;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.SalesAndTrafficByAsin;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.SalesAndTrafficByDate;

@Data
@Accessors(chain = true)
@Document(collection = "test_report")
public class Report {
    @Id
    private String id;
    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
}
