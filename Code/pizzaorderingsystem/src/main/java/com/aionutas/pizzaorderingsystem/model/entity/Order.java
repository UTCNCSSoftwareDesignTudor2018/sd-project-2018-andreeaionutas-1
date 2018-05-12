package com.aionutas.pizzaorderingsystem.model.entity;

import com.aionutas.pizzaorderingsystem.model.utils.OrderStatus;

import java.util.List;
import java.util.Observable;

public class Order {
    private Long id;
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private String address;
    private OrderStatus orderStatus;

    public Order(Long id, List<Pizza> pizzas, List<Drink> drinks, String address) {
        this.id = id;
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.address = address;
    }

    public Order(Long id, List<Pizza> pizzas, List<Drink> drinks, String address, OrderStatus orderStatus) {
        this.id = id;
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    public Order(List<Pizza> pizzas, List<Drink> drinks, String address, OrderStatus orderStatus) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    public Order(List<Pizza> pizzas, List<Drink> drinks, String address) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.address = address;
    }

    public Order(Long id, List<Pizza> pizzas, String address) {
        this.id = id;
        this.pizzas = pizzas;
        this.address = address;
    }

    public Order(List<Pizza> pizzas, String address) {
        this.pizzas = pizzas;
        this.address = address;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        //notifyObservers();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (pizzas != null ? !pizzas.equals(order.pizzas) : order.pizzas != null) return false;
        if (drinks != null ? !drinks.equals(order.drinks) : order.drinks != null) return false;
        return address != null ? address.equals(order.address) : order.address == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pizzas != null ? pizzas.hashCode() : 0);
        result = 31 * result + (drinks != null ? drinks.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", pizzas=" + pizzas +
                ", drinks=" + drinks +
                ", address='" + address + '\'' +
                '}';
    }
}
