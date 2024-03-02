package stat_sync_analyzer.model.report.reportSpecification;

import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import stat_sync_analyzer.model.report.reportSpecification.reportOptions.ReportOptions;

@Data
@Document(collection = "test_report")
public class ReportSpecification {
    private String dataEndTime;
    private String dataStartTime;
    private List<String> marketplaceIds;
    private ReportOptions reportOptions;
    private String reportType;
}
