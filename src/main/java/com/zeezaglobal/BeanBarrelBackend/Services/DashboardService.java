package com.zeezaglobal.BeanBarrelBackend.Services;

import com.zeezaglobal.BeanBarrelBackend.DTO.DashboardResponse;
import com.zeezaglobal.BeanBarrelBackend.Entities.Sale;
import com.zeezaglobal.BeanBarrelBackend.Repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final SaleRepository saleRepository;

    public DashboardService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public DashboardResponse getDashboardData(LocalDateTime startDate, LocalDateTime endDate, Integer storeId) {
        DashboardResponse response = new DashboardResponse();

        // 1. Fetch sales filtered by date & store
        List<Sale> filteredSales = saleRepository.findByDateTimeBetweenAndStore(startDate, endDate, storeId);

        long totalSalesCount = filteredSales.size();
        double totalRevenue = filteredSales.stream().mapToDouble(Sale::getTotalAmount).sum();

        // 2. Payment Method Breakdown
        Map<String, Long> paymentMethodMap = filteredSales.stream()
                .collect(Collectors.groupingBy(Sale::getPaymentMethod, Collectors.counting()));

        // 3. Status Breakdown
        Map<String, Long> statusMap = filteredSales.stream()
                .collect(Collectors.groupingBy(s -> String.valueOf(s.getStatus()), Collectors.counting()));

        // 4. Hourly Sales Data (Map<"2025-10-05 14:00", revenue>)
        Map<String, Double> hourlySalesMap = filteredSales.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getDateTime().withMinute(0).withSecond(0).withNano(0).toString(),
                        Collectors.summingDouble(Sale::getTotalAmount)
                ));

        response.setTotalSalesCount(totalSalesCount);
        response.setTotalRevenue(totalRevenue);
        response.setSalesByPaymentMethod(paymentMethodMap);
        response.setSalesByStatus(statusMap);
        response.setHourlySales(hourlySalesMap);

        return response;
    }
}
