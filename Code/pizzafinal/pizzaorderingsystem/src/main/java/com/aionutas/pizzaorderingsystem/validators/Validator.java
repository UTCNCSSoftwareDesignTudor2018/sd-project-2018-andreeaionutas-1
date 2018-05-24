package com.aionutas.pizzaorderingsystem.validators;

public interface Validator<T> {
    public boolean validate(T t);
}
