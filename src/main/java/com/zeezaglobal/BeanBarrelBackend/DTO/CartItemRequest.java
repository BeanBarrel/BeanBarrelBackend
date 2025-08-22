package com.zeezaglobal.BeanBarrelBackend.DTO;

public class CartItemRequest {
    private Long itemId;
    private int quantity;

    // Getters and Setters
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}