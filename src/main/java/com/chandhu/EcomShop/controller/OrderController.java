package com.chandhu.EcomShop.controller;

import com.chandhu.EcomShop.model.OrderItem;
import com.chandhu.EcomShop.model.dto.OrderItemRequest;
import com.chandhu.EcomShop.model.dto.OrderRequest;
import com.chandhu.EcomShop.model.dto.OrderResponse;
import com.chandhu.EcomShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        return  new ResponseEntity<>(orderResponse, HttpStatus.CREATED);

    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> responses = orderService.getAllResponse();
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }
}
