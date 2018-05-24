package com.aionutas.pizzaorderingsystem.model.utils;

public interface PaymentStrategy {
    public String pay(Long amount);
}
