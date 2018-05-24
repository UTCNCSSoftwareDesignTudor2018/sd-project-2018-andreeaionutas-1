package com.aionutas.pizzaorderingsystem.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.aionutas.pizzaorderingsystem.model.entity.Ingredient.getTotalIngredientsPrice;
import static com.aionutas.pizzaorderingsystem.model.entity.Topping.getTotalToppingsPrice;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Pizza {
    @Id
    public Long id;
    private String name;
    private List<Ingredient> ingredients;
    private List<Topping> toppings;
    private Long price;

    public Pizza(Long id, List<Ingredient> ingredients, List<Topping> toppings, Long price, String name) {
        this.id = id;
        this.ingredients = ingredients;
        this.toppings = toppings;
        this.price = price;
        this.name = name;
    }


    public Pizza(List<Ingredient> ingredients, List<Topping> toppings, Long price, String name) {
        this.ingredients = ingredients;
        this.toppings = toppings;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pizza() {
    }

    public Pizza(Long id, List<Ingredient> ingredients, List<Topping> toppings) {
        this.id = id;
        this.ingredients = ingredients;
        this.toppings = toppings;
    }

    public Pizza(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Pizza(List<Ingredient> ingredients, List<Topping> toppings) {
        this.ingredients = ingredients;
        this.toppings = toppings;
    }

    public Long getId() {
        return id;
    }


    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (ingredients != null ? !ingredients.equals(pizza.ingredients) : pizza.ingredients != null) return false;
        return toppings != null ? toppings.equals(pizza.toppings) : pizza.toppings == null;
    }

    @Override
    public int hashCode() {
        int result = ingredients != null ? ingredients.hashCode() : 0;
        result = 31 * result + (toppings != null ? toppings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredients=" + ingredients +
                ", toppings=" + toppings +
                '}';
    }

    public static Long getTotal(List<Ingredient> ingredients, List<Topping> toppings) {
        Long ingredientsPrice;
        Long toppingsPrice;
        Long total;

        ingredientsPrice = getTotalIngredientsPrice(ingredients);
        toppingsPrice = getTotalToppingsPrice(toppings);
        total = ingredientsPrice + toppingsPrice;
        return total;

    }
}
