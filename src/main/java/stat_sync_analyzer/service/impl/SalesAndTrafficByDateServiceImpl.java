package stat_sync_analyzer.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.SalesAndTrafficByDate;
import stat_sync_analyzer.repository.SalesAndTrafficByDateRepository;
import stat_sync_analyzer.service.SalesAndTrafficByDateService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "salesAndTrafficByDate")
@Service
public class SalesAndTrafficByDateServiceImpl implements SalesAndTrafficByDateService {
    private static final String PLUG = "";
    private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;

    @Cacheable
    @Override
    public List<SalesAndTrafficByDate> getSalesAndTrafficByDate(int pageNumber,
                                                                int pageCount,
                                                                String date,
                                                                String startDate,
                                                                String endDate) {
        if ((date == null || !date.matches(DATE_PATTERN))
                && (startDate == null || !startDate.matches(DATE_PATTERN))
                && (endDate == null || !endDate.matches(DATE_PATTERN))) {
            return salesAndTrafficByDateRepository.findAllSalesAndTrafficByDate(pageNumber, pageCount);
        }

        date = (date != null && date.matches(DATE_PATTERN)) ? date : PLUG;
        startDate = (startDate != null && startDate.matches(DATE_PATTERN)) ? startDate : PLUG;
        endDate = (endDate != null && endDate.matches(DATE_PATTERN)) ? endDate : PLUG;


        return salesAndTrafficByDateRepository.findAllSalesAndTrafficByDate(
                pageNumber, pageCount, date, startDate, endDate);
    }

    @CachePut
    @Override
    public List<SalesAndTrafficByDate> updateSalesAndTrafficByDate(int pageNumber, int pageCount) {
        return salesAndTrafficByDateRepository.findAllSalesAndTrafficByDate(pageNumber, pageCount);
    }

    @Scheduled(cron = "*/5 * * * *")
    @CachePut
    public void updateSalesAndTrafficByDate() {
        salesAndTrafficByDateRepository.findAllSalesAndTrafficByDate();
    }
}
