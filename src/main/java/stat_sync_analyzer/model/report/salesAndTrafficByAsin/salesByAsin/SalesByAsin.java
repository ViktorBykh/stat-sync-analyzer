package stat_sync_analyzer.model.report.salesAndTrafficByAsin.salesByAsin;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.salesByAsin.orderedProductSales.OrderedProductSales;
import stat_sync_analyzer.model.report.salesAndTrafficByAsin.salesByAsin.orderedProductSalesB2B.OrderedProductSalesB2B;

@Data
@Document(collection = "test_report")
public class SalesByAsin {
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
}
