package com.aionutas.pizzaorderingsystem.model.entity;

import java.util.List;

public class Topping {
    private Long id;
    private String name;
    private Long price;

    public Topping() {
    }

    public Topping(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Topping(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topping topping = (Topping) o;

        if (id != null ? !id.equals(topping.id) : topping.id != null) return false;
        if (name != null ? !name.equals(topping.name) : topping.name != null) return false;
        return price != null ? price.equals(topping.price) : topping.price == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Long getTotalToppingsPrice(List<Topping> toppings){
        Long price = Long.valueOf(0);
        if(!toppings.isEmpty()){
            for (Topping topping: toppings){
                price += price + topping.getPrice();
            }
        }
        return price;
    }
}
