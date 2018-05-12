package com.aionutas.pizzaorderingsystem.service;


import com.aionutas.pizzaorderingsystem.model.entity.Order;
import com.aionutas.pizzaorderingsystem.model.repository.OrderRepo;
import com.aionutas.pizzaorderingsystem.model.utils.OrderStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = OrderRepo.class)
@Configuration
public class OrderService extends java.util.Observable {

    @Autowired
    OrderRepo orderRepo;

        public void addOrder(Order order) {

             order.setOrderStatus(OrderStatus.PROCESSED);
             notifyObservers();
             orderRepo.save(order);
    }

    public Optional<Order> getById(Long id) {
        return orderRepo.findById(id);
    }

    public void deleteOrder(Long id) {
        Order deleteOrder = orderRepo.findById(id).get();

        if (deleteOrder.getId() != null) {
            orderRepo.delete(deleteOrder);
        } else {
            System.out.println("Could not delete order!");
        }

    }

    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

}
