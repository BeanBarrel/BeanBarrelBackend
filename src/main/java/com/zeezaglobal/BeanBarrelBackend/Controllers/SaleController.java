package com.zeezaglobal.BeanBarrelBackend.Controllers;

import com.zeezaglobal.BeanBarrelBackend.DTO.SaleRequest;
import com.zeezaglobal.BeanBarrelBackend.Entities.Sale;
import com.zeezaglobal.BeanBarrelBackend.Services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // Get Sale by bill number
    @GetMapping("/{billNumber}")
    public ResponseEntity<Sale> getSale(@PathVariable Long billNumber) {
        Sale sale = saleService.getSaleByBillNumber(billNumber);
        if (sale != null) {
            return ResponseEntity.ok(sale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
