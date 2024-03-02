package stat_sync_analyzer.model.report.salesAndTrafficByDate.trafficByDate;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test_report")
public class TrafficByDate {
    private int averageOfferCount;
    private int averageParentItems;
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int browserSessions;
    private int browserSessionsB2B;
    private double buyBoxPercentage;
    private double buyBoxPercentageB2B;
    private int feedbackReceived;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int negativeFeedbackReceived;
    private double orderItemSessionPercentage;
    private double orderItemSessionPercentageB2B;
    private int pageViews;
    private int pageViewsB2B;
    private int receivedNegativeFeedbackRate;
    private int sessions;
    private int sessionsB2B;
    private double unitSessionPercentage;
    private int unitSessionPercentageB2B;
}
