package com.zeezaglobal.BeanBarrelBackend.Services;

import com.zeezaglobal.BeanBarrelBackend.DTO.DashboardResponse;
import com.zeezaglobal.BeanBarrelBackend.Repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final SaleRepository saleRepository;

    public DashboardService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public DashboardResponse getDashboardData() {
        DashboardResponse response = new DashboardResponse();

        long totalSales = saleRepository.count();
        double totalRevenue = saleRepository.findAll()
                .stream()
                .mapToDouble(s -> s.getTotalAmount())
                .sum();

        // Monthly Sales
        List<DashboardResponse.MonthlySalesData> monthlySales = saleRepository.getMonthlySalesSummary()
                .stream()
                .map(obj -> new DashboardResponse.MonthlySalesData(
                        (String) obj[0],
                        (Long) obj[1],
                        (Double) obj[2]
                )).collect(Collectors.toList());

        // Payment Method Breakdown
        Map<String, Long> paymentMethodMap = saleRepository.getSalesByPaymentMethod()
                .stream()
                .collect(Collectors.toMap(
                        obj -> (String) obj[0],
                        obj -> (Long) obj[1]
                ));

        // Status Breakdown
        Map<String, Long> statusMap = saleRepository.getSalesByStatus()
                .stream()
                .collect(Collectors.toMap(
                        obj -> String.valueOf(obj[0]),
                        obj -> (Long) obj[1]
                ));

        // Store Sales
        Map<Integer, Double> storeSalesMap = saleRepository.getStoreSales()
                .stream()
                .collect(Collectors.toMap(
                        obj -> (Integer) obj[0],
                        obj -> (Double) obj[1]
                ));

        response.setTotalSalesCount(totalSales);
        response.setTotalRevenue(totalRevenue);
        response.setMonthlySales(monthlySales);
        response.setSalesByPaymentMethod(paymentMethodMap);
        response.setSalesByStatus(statusMap);
        response.setStoreSales(storeSalesMap);

        return response;
    }
}
