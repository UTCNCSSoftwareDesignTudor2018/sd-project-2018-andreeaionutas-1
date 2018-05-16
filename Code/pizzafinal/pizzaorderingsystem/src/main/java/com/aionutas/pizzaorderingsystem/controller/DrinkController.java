package com.aionutas.pizzaorderingsystem.controller;


import com.aionutas.pizzaorderingsystem.model.entity.Drink;
import com.aionutas.pizzaorderingsystem.model.entity.Topping;
import com.aionutas.pizzaorderingsystem.service.DrinkService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    DrinkService drinkService;
    Random rand = new Random();
    @RequestMapping(value = "/findDrink/{id}", method = RequestMethod.GET)
    public Drink findDrinkByID(@PathVariable Long id) {
        return drinkService.getById(id).get();
    }


    @RequestMapping(value = "/addDrink", method = RequestMethod.POST)
    public Drink addDrink(@RequestBody Drink drink) {
        drink.setId(Long.valueOf(rand.nextInt(1000)));
        if(!drinkService.getById(drink.getId()).isPresent()){
            return drinkService.addDrink(drink);}
        else return null;
    }

    @RequestMapping(value = "/findDrink/", method = RequestMethod.GET)
    public Drink findDrinkByName(@RequestParam String name) throws JSONException {
        return drinkService.getByName(name);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteDrink(@PathVariable(value = "id") Long id) {
        drinkService.deleteDrink(id);
    }

    @RequestMapping(value = "/drinks", method = RequestMethod.GET)
    public List<Drink> getAllDrinks() {
        return drinkService.findAllDrinks();
    }

    @RequestMapping(value = "/updateDrink", method = RequestMethod.PUT)
    public Drink updateDrink(@RequestBody Drink drink) {
        Drink existingDrink = drinkService.getById(drink.getId()).get();
        if (existingDrink.getId() != null) {
            drink.setId(existingDrink.getId());
            return drinkService.updateDrink(drink);
        }
        return null;
    }
}
