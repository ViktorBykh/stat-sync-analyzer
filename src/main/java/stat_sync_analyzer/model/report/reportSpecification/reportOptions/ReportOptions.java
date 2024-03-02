package stat_sync_analyzer.model.report.reportSpecification.reportOptions;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class ReportOptions {
    private String asinGranularity;
    private String dateGranularity;
}
