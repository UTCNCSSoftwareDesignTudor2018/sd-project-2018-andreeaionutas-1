package com.aionutas.pizzaorderingsystem.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Ingredient {
    private Long id;
    private String name;
    private Long price;

    public Ingredient(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Ingredient(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Ingredient() {
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

        Ingredient that = (Ingredient) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return price != null ? price.equals(that.price) : that.price == null;
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
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Long getTotalIngredientsPrice(List<Ingredient> ingredients){
        Long price = Long.valueOf(0);
        if(!ingredients.isEmpty()){
            for (Ingredient ingredient: ingredients){
                price += price + ingredient.getPrice();
            }
        }
        return price;
    }


}
