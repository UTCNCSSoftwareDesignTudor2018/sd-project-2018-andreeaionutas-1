package com.aionutas.pizzaorderingsystem.controller;



import com.aionutas.pizzaorderingsystem.model.utils.CreditCardStrategy;
import com.aionutas.pizzaorderingsystem.model.utils.PaypalStrategy;
import com.aionutas.pizzaorderingsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PayController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "pay/{orderId}", method = RequestMethod.POST)
    public String pay(@RequestParam(value = "payment") String payment,
            @PathVariable(value = "orderId") Long orderId, @RequestParam(value = "email", required = false) String email,
                      @RequestParam(value = "password", required = false) String password,
                      @RequestParam(value = "name", required = false) String name,
                      @RequestParam(value = "cardNumber", required = false) String cardNumber,
                      @RequestParam(value = "cvv", required = false) String cvv){

        if(payment.equalsIgnoreCase("PayPal"))
        {
            return orderService.pay(new PaypalStrategy(email, password), orderId);
        }
        else {
            return orderService.pay(new CreditCardStrategy(name, cardNumber, cvv), orderId);
        }
    }





}
