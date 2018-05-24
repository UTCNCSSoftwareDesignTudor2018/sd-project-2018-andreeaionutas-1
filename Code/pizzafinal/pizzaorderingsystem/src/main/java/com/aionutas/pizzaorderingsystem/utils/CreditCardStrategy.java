package com.aionutas.pizzaorderingsystem.model.utils;

public class CreditCardStrategy implements PaymentStrategy {


    private String name;
    private String cardNumber;
    private String cvv;


    public CreditCardStrategy(String nm, String ccNum, String cvv) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;

    }

    @Override
    public String pay(Long amount) {
        return new String (amount + " paid with credit/debit card");
    }

}
