package stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSalesPerOrderItem.AverageSalesPerOrderItem;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSalesPerOrderItemB2B.AverageSalesPerOrderItemB2B;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSellingPrice.AverageSellingPrice;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.averageSellingPriceB2B.AverageSellingPriceB2B;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.claimsAmount.ClaimsAmount;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.orderedProductSales.OrderedProductSales;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.orderedProductSalesB2B.OrderedProductSalesB2B;
import stat_sync_analyzer.model.report.salesAndTrafficByDate.salesByDate.shippedProductSales.ShippedProductSales;

@Data
@Document(collection = "test_report")
public class SalesByDate {
    private AverageSalesPerOrderItem averageSalesPerOrderItem;
    private AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
    private AverageSellingPrice averageSellingPrice;
    private AverageSellingPriceB2B averageSellingPriceB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private ClaimsAmount claimsAmount;
    private int claimsGranted;
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int ordersShipped;
    private double refundRate;
    private ShippedProductSales shippedProductSales;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int unitsRefunded;
    private int unitsShipped;
}
