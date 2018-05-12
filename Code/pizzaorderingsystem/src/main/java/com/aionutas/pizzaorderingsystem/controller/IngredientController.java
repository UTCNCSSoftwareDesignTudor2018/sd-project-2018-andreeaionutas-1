package com.aionutas.pizzaorderingsystem.controller;

import com.aionutas.pizzaorderingsystem.model.entity.Ingredient;
import com.aionutas.pizzaorderingsystem.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")

public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @RequestMapping(value = "/findIngredient/{id}", method = RequestMethod.GET)
    public Ingredient findIngredientById(@PathVariable Long id) {
        return ingredientService.getById(id).get();
    }


    @RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        if(!ingredientService.getById(ingredient.getId()).isPresent()){
            return ingredientService.addIngredient(ingredient);}
        else return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteIngredient(@PathVariable(value = "id") Long id) {
        ingredientService.deleteIngredient(id);
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAllIngredients();
    }

    @RequestMapping(value = "/updateIngredient", method = RequestMethod.PUT)
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        Ingredient existingIngredient= ingredientService.getById(ingredient.getId()).get();
        if (existingIngredient.getId() != null) {
            ingredient.setId(existingIngredient.getId());
            return ingredientService.updateIngredient(ingredient);
        }
        return null;
    }
}
