package com.chandhu.EcomShop.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {
}
