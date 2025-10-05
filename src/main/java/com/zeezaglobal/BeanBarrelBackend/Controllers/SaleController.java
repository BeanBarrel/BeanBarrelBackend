package com.zeezaglobal.BeanBarrelBackend.Controllers;

import com.zeezaglobal.BeanBarrelBackend.DTO.SaleRequest;
import com.zeezaglobal.BeanBarrelBackend.Entities.Sale;
import com.zeezaglobal.BeanBarrelBackend.Services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    // Create a new Sale
    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody SaleRequest request) {
        saleService.createSale(request);
        return ResponseEntity.ok().body("{\"message\": \"Sale created successfully\"}");
    }
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/by-date-store")
    public ResponseEntity<Page<Sale>> getSalesByDateAndStore(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("store") int store,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        LocalDateTime start = date.atTime(3, 0);
        LocalDateTime end = date.plusDays(1).atTime(3, 0);

        System.out.println(">>> Fetching sales for store: " + store
                + " on date: " + date
                + " (start: " + start + ", end: " + end + ")");

        Page<Sale> salesPage = saleService.getSalesByStoreAndDateRange(store, start, end, page, size);

        System.out.println(">>> Total sales found on this page: " + salesPage.getNumberOfElements());

        return ResponseEntity.ok(salesPage);
    }
    // Get Sale by bill number

}
