package com.aionutas.pizzaorderingsystem.controller;


import com.aionutas.pizzaorderingsystem.model.entity.Order;
import com.aionutas.pizzaorderingsystem.model.utils.CreditCardStrategy;
import com.aionutas.pizzaorderingsystem.model.utils.PaypalStrategy;
import com.aionutas.pizzaorderingsystem.service.OrderService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    Random rand = new Random();



    @CrossOrigin
    @RequestMapping(value = "/findOrder/{id}", method = RequestMethod.GET)
    public Order findOrderById(@PathVariable Long id) {
        return orderService.getById(id).get();
    }

    @CrossOrigin
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public Order addOrder(@RequestBody Order order) throws JSONException {
        order.setId(Long.valueOf(rand.nextInt(1000)));
        if (!orderService.getById(order.getId()).isPresent()) {

            return orderService.addOrder(order);
        } else return null;
    }
    @CrossOrigin
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable(value = "id") Long id) {
        orderService.deleteOrder(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @CrossOrigin
    @RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order) {
        Order existingOrder = orderService.getById(order.getId()).get();
        if (existingOrder.getId() != null) {
            order.setId(existingOrder.getId());
            return orderService.updateOrder(order);
        }
        return null;
    }

    @RequestMapping(value = "/pay/{orderId}", method = RequestMethod.POST)
    public String pay(@RequestParam(value = "paymentMethod") String paymentMethod,
                    @PathVariable(value = "orderId") Long orderId, @RequestParam (value = "email", required = false) String email,
                    @RequestParam(value = "password", required = false) String password,@RequestParam(value ="name", required = false) String name,
                    @RequestParam(value = "cardNumber", required = false) String cardNumber, @RequestParam(value = "cvv", required = false) String cvv)
    {
        if(paymentMethod.equalsIgnoreCase("card")){
            return orderService.pay(new CreditCardStrategy(name, cardNumber, cvv), orderId);
        }
        else  if(paymentMethod.equalsIgnoreCase("paypal")){
            return orderService.pay(new PaypalStrategy(email, password), orderId);
        }
        return null;
    }
}
