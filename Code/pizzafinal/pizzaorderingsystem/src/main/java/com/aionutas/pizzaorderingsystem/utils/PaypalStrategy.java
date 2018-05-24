package com.aionutas.pizzaorderingsystem.model.utils;

public class PaypalStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public PaypalStrategy(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }

    @Override
    public String pay(Long amount) {
       return new String(amount + " paid using Paypal.");
    }

}
