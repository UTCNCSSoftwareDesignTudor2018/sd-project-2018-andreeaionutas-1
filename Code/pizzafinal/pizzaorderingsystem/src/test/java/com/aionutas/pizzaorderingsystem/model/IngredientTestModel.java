package com.aionutas.pizzaorderingsystem.model;

import com.aionutas.pizzaorderingsystem.model.entity.Ingredient;

import static com.aionutas.pizzaorderingsystem.model.entity.Ingredient.builder;

public class IngredientTestModel {
    public static Ingredient createIngredient() {
        return Ingredient.builder().setName("olives").setId(Long.valueOf(178)).setPrice(Long.valueOf(2)).build();
    }
}
