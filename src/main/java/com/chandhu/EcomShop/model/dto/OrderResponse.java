package com.chandhu.EcomShop.model.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
        String OrderId,
        String customerName,
        String name,
        String status,
        LocalDate orderDate,
        List<OrderItemResponse> items
) {
}
