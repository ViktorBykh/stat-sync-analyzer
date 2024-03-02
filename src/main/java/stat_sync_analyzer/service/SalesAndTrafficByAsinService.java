package stat_sync_analyzer.service;

import java.util.List;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.SalesAndTrafficByAsin;

public interface SalesAndTrafficByAsinService {
    List<SalesAndTrafficByAsin> getSalesAndTrafficByAsin(int pageNumber,
                                                         int pageCount,
                                                         String asin,
                                                         List<String> asins);

    List<SalesAndTrafficByAsin> updateSalesAndTrafficByAsin(int pageNumber, int pageCount);
}
