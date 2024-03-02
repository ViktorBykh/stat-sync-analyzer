package stat_sync_analyzer.service.impl;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.SalesAndTrafficByAsin;
import stat_sync_analyzer.repository.SalesAndTrafficByAsinRepository;
import stat_sync_analyzer.service.SalesAndTrafficByAsinService;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "salesAndTrafficByAsin")
@Service
public class SalesAndTrafficByAsinServiceImpl implements SalesAndTrafficByAsinService {
    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;

    @Cacheable
    @Override
    public List<SalesAndTrafficByAsin> getSalesAndTrafficByAsin(int pageNumber,
                                                                int pageCount,
                                                                String asin,
                                                                List<String> asins) {
        if (isAsinParametersEmpty(asin, asins)) {
            return salesAndTrafficByAsinRepository.findAllSalesAndTrafficByAsin(pageNumber, pageCount);
        } else {
            String nonNullAsin = getNonNullAsin(asin);
            List<String> nonNullAsins = getNonNullAsins(asins);
            return salesAndTrafficByAsinRepository
                    .findAllSalesAndTrafficByAsin(pageNumber, pageCount, nonNullAsin, nonNullAsins);
        }
    }

    @CachePut
    @Override
    public List<SalesAndTrafficByAsin> updateSalesAndTrafficByAsin(int pageNumber, int pageCount) {
        return salesAndTrafficByAsinRepository.findAllSalesAndTrafficByAsin(pageNumber, pageCount);
    }

    @Scheduled(cron = "*/5 * * * *")
    @CachePut
    public void updateSalesAndTrafficByAsin() {
       salesAndTrafficByAsinRepository.findAllSalesAndTrafficByAsin();
    }

    private boolean isAsinParametersEmpty(String asin, List<String> asins) {
        return (asin == null || asin.isBlank()) && (asins == null || asins.isEmpty());
    }

    private String getNonNullAsin(String asin) {
        return (asin == null || asin.isBlank()) ? "" : asin;
    }

    private List<String> getNonNullAsins(List<String> asins) {
        return (asins == null || asins.isEmpty()) ? Collections.emptyList() : asins;
    }
}
