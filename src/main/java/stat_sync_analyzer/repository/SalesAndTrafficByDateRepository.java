package stat_sync_analyzer.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.SalesAndTrafficByDate;

@Repository
public interface SalesAndTrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {
    @Aggregation(pipeline = {
            "{$unwind: '$salesAndTrafficByDate'}",
            "{$replaceRoot: {newRoot: '$salesAndTrafficByDate'}}",
            "{$match: {$or: [{date: ?2}, {$and: [{date: {$gte: ?3}}, {date: {$lte: ?4}}]}]}}",
            "{$skip: ?0}",
            "{$limit: ?1}"})
    List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate(int pageNumber,
                                                             int pageCount,
                                                             String date,
                                                             String startDate,
                                                             String endDate);

    @Aggregation(pipeline = {
            "{$unwind: '$salesAndTrafficByDate'}",
            "{$replaceRoot: {newRoot: '$salesAndTrafficByDate'}}",
            "{$skip: ?0}",
            "{$limit: ?1}"})
    List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate(int pageNumber,
                                                             int pageCount);

    @Aggregation(pipeline = {
            "{$unwind: '$salesAndTrafficByDate'}",
            "{$replaceRoot: {newRoot: '$salesAndTrafficByDate'}}"})
    void findAllSalesAndTrafficByDate();
}
