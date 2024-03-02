package stat_sync_analyzer.service;

import java.util.List;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.SalesAndTrafficByDate;

public interface SalesAndTrafficByDateService {
    List<SalesAndTrafficByDate> getSalesAndTrafficByDate(int pageNumber,
                                                         int pageCount,
                                                         String date,
                                                         String startDate,
                                                         String endDate);

    List<SalesAndTrafficByDate> updateSalesAndTrafficByDate(int pageNumber,
                                                         int pageCount);
}
