package com.zeezaglobal.BeanBarrelBackend.Controllers;

import com.zeezaglobal.BeanBarrelBackend.DTO.DashboardResponse;
import com.zeezaglobal.BeanBarrelBackend.Services.DashboardService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/dashboard")

public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponse getDashboardData(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam("storeId") Integer storeId
    ) {
        return dashboardService.getDashboardData(startDate, endDate, storeId);
    }
}