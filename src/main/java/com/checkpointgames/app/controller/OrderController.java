package com.checkpointgames.app.controller;

import com.checkpointgames.app.entity.Order;
import com.checkpointgames.app.service.OrderService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    // CREATE
    @PostMapping("/createOrder")
    public Order saveOrder(@Valid @RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    // UPDATE
    @PostMapping("/updateOrder")
    public Order updateOrder(@Valid @RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    // LIST ALL
    @GetMapping("/showOrders")
    public List<Order> showOrders(Order order) {
        return orderService.showGames(order);
    }
    
    // LIST OPEN
    @GetMapping("/showOpenOrders")
    public List<Order> showOpenOrders(Order order) {
        return orderService.showOpenOrders(order);
    }

    // LIST CLOSED
    @GetMapping("/showClosedOrders")
    public List<Order> showClosedOrders(Order order) {
        return orderService.showClosedOrders(order);
    }

    // LIST CANCELED
    @GetMapping("/showCanceledOrders")
    public List<Order> showCanceledOrders(Order order) {
        return orderService.showCanceledOrders(order);
    }

    // LIST BY CUSTOMER
    @GetMapping("/showOrdersByCostumer/{id}")
    public List<Order> showOrderByCostumer(@PathVariable Integer id) {
        return orderService.showOrderByCostumer(id);
    }

    // LIST BY ID
    @GetMapping("/showOrdersById/{id}")
    public ResponseEntity<Order> showOrdersById(@PathVariable Integer id) {
        return orderService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
