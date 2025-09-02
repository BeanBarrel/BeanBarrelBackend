package com.zeezaglobal.BeanBarrelBackend.Services;

import com.zeezaglobal.BeanBarrelBackend.DTO.CartItemRequest;
import com.zeezaglobal.BeanBarrelBackend.DTO.SaleRequest;
import com.zeezaglobal.BeanBarrelBackend.Entities.CartItem;
import com.zeezaglobal.BeanBarrelBackend.Entities.Item;
import com.zeezaglobal.BeanBarrelBackend.Entities.Sale;
import com.zeezaglobal.BeanBarrelBackend.Repositories.ItemRepository;
import com.zeezaglobal.BeanBarrelBackend.Repositories.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ItemRepository itemRepository;

    public SaleService(SaleRepository saleRepository, ItemRepository itemRepository) {
        this.saleRepository = saleRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Sale createSale(SaleRequest request) {
        // Check if a sale with this billNumber already exists
        Optional<Sale> existingSaleOpt = saleRepository.findByBillNumber(request.getBillNumber());

        if (existingSaleOpt.isPresent()) {
            // Just update the status
            Sale existingSale = existingSaleOpt.get();
            existingSale.setStatus(request.getStatus());
            return saleRepository.save(existingSale);
        }

        // Otherwise create a new sale
        Sale sale = new Sale();
        sale.setBillNumber(request.getBillNumber());
        sale.setTokenNumber(request.getTokenNumber());
        sale.setStatus(request.getStatus());
        sale.setStore(request.getStore());
        sale.setTotalAmount(request.getTotalAmount());
        sale.setPaymentMethod(request.getPaymentMethod());
        sale.setCustomerName(request.getCustomerName());
        sale.setCustomerEmail(request.getCustomerEmail());
        sale.setCustomerPhone(request.getCustomerPhone());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sale.setDateTime(LocalDateTime.parse(request.getDateTime(), formatter));

        // Add cart items only for NEW sale
        List<CartItem> cartItems = new ArrayList<>();
        for (CartItemRequest itemReq : request.getItems()) {
            Item item = itemRepository.findById(itemReq.getItemId().intValue())
                    .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemReq.getItemId()));

            CartItem cartItem = new CartItem();
            cartItem.setItem(item);
            cartItem.setQuantity(itemReq.getQuantity());
            cartItem.setSale(sale);
            cartItems.add(cartItem);
        }
        sale.setItems(cartItems);

        return saleRepository.save(sale);
    }

    public List<Sale> getSalesByStoreAndDateRange(int store, LocalDateTime start, LocalDateTime end) {
        return saleRepository.findByStoreAndDateTimeBetween(store, start, end);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }


}
