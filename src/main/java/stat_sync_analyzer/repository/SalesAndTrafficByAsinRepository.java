package stat_sync_analyzer.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.SalesAndTrafficByAsin;

@Repository
public interface SalesAndTrafficByAsinRepository
        extends MongoRepository<SalesAndTrafficByAsin, String> {
    @Aggregation(pipeline = {
            "{$unwind: '$salesAndTrafficByAsin'}",
            "{$replaceRoot: {newRoot: '$salesAndTrafficByAsin'}}",
            "{$match: {$or: [{parentAsin: { $eq: ?2}}, {parentAsin: {$in: ?3}}]}}",
            "{$skip: ?0}",
            "{$limit: ?1}"})
    List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin(int pageNumber,
                                                             int pageCount,
                                                             String asin,
                                                             List<String> asins);

    @Aggregation(pipeline = {
            "{$unwind: '$salesAndTrafficByAsin'}",
            "{$replaceRoot: {newRoot: '$salesAndTrafficByAsin'}}",
            "{$skip: ?0}",
            "{$limit: ?1}"})
    List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin(int pageNumber,
                                                             int pageCount);

    @Aggregation(pipeline = {
            "{$unwind: '$salesAndTrafficByAsin'}",
            "{$replaceRoot: {newRoot: '$salesAndTrafficByAsin'}}"})
    void findAllSalesAndTrafficByAsin();
}
