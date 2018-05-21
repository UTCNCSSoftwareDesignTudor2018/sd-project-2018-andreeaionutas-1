package com.aionutas.pizzaorderingsystem.controller;

import com.aionutas.pizzaorderingsystem.model.entity.Ingredient;
import com.aionutas.pizzaorderingsystem.service.IngredientService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/ingredients")

public class IngredientController {

    @Autowired
    IngredientService ingredientService;
    Random rand = new Random();

    @RequestMapping(value = "/findIngredient/{id}", method = RequestMethod.GET)
    public Ingredient findIngredientById(@PathVariable Long id) {
        return ingredientService.getById(id).get();
    }


    @RequestMapping(value = "/findIngredient/", method = RequestMethod.GET)
    public Ingredient findIngredientByName(@RequestParam String name) throws JSONException {
        return ingredientService.getByName(name);
    }

    @RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        ingredient.setId(Long.valueOf(rand.nextInt(1000)));
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
