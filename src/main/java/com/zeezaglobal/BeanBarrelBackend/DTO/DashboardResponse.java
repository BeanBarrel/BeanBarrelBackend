package com.zeezaglobal.BeanBarrelBackend.DTO;

import java.util.List;
import java.util.Map;

public class DashboardResponse {

    private long totalSalesCount;
    private double totalRevenue;
    private Map<String, Long> salesByPaymentMethod;
    private Map<String, Long> salesByStatus;
    private List<MonthlySalesData> monthlySales;
    private Map<Integer, Double> storeSales;

    // Nested DTO for monthly sales
    public static class MonthlySalesData {
        private String month;
        private long salesCount;
        private double revenue;

        public MonthlySalesData(String month, long salesCount, double revenue) {
            this.month = month;
            this.salesCount = salesCount;
            this.revenue = revenue;
        }

        public String getMonth() { return month; }
        public long getSalesCount() { return salesCount; }
        public double getRevenue() { return revenue; }
    }

    public long getTotalSalesCount() { return totalSalesCount; }
    public void setTotalSalesCount(long totalSalesCount) { this.totalSalesCount = totalSalesCount; }

    public double getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }

    public Map<String, Long> getSalesByPaymentMethod() { return salesByPaymentMethod; }
    public void setSalesByPaymentMethod(Map<String, Long> salesByPaymentMethod) { this.salesByPaymentMethod = salesByPaymentMethod; }

    public Map<String, Long> getSalesByStatus() { return salesByStatus; }
    public void setSalesByStatus(Map<String, Long> salesByStatus) { this.salesByStatus = salesByStatus; }

    public List<MonthlySalesData> getMonthlySales() { return monthlySales; }
    public void setMonthlySales(List<MonthlySalesData> monthlySales) { this.monthlySales = monthlySales; }

    public Map<Integer, Double> getStoreSales() { return storeSales; }
    public void setStoreSales(Map<Integer, Double> storeSales) { this.storeSales = storeSales; }
}
