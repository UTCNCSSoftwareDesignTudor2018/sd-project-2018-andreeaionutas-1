package com.aionutas.pizzaorderingsystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class PizzaStore {
    private Long id;
    private String name;
    private String username;
    private String password;
    private List<Pizza> pizzas;
    private List<Drink> drinks;


    public PizzaStore(Long id, String name, String username, String password, List<Pizza> pizzas, List<Drink> drinks) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.pizzas = pizzas;
        this.drinks = drinks;
    }


    public PizzaStore(String name, String username, String password, List<Pizza> pizzas, List<Drink> drinks) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.pizzas = pizzas;
        this.drinks = drinks;
    }

    public PizzaStore(Long id, String name, String username, List<Pizza> pizzas, List<Drink> drinks) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.pizzas = pizzas;
        this.drinks = drinks;
    }

    public PizzaStore(String name, String username, List<Pizza> pizzas, List<Drink> drinks) {
        this.name = name;
        this.username = username;
        this.pizzas = pizzas;
        this.drinks = drinks;
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

    public PizzaStore(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public PizzaStore(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PizzaStore() {
    }

    public PizzaStore(String name) {
        this.name = name;

    }

    public PizzaStore(Long id, String name) {
        this.id = id;
        this.name = name;
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


}
