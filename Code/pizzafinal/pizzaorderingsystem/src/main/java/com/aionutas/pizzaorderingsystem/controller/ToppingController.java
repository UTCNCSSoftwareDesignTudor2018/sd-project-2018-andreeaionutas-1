package com.aionutas.pizzaorderingsystem.controller;


import com.aionutas.pizzaorderingsystem.model.entity.Order;
import com.aionutas.pizzaorderingsystem.model.entity.Topping;
import com.aionutas.pizzaorderingsystem.service.ToppingService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/toppings")
public class ToppingController {


    @Autowired
    ToppingService toppingService;
    Random rand = new Random();

    @RequestMapping(value = "/findTopping/{id}", method = RequestMethod.GET)
    public Topping findToppingById(@PathVariable Long id) {
        return toppingService.getById(id).get();
    }


    @RequestMapping(value = "/addTopping", method = RequestMethod.POST)
    public Topping addTopping(@RequestBody Topping topping) {
        topping.setId(Long.valueOf(rand.nextInt(1000)));
        if(!toppingService.getById(topping.getId()).isPresent()){
            return toppingService.addTopping(topping);}
        else return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTopping(@PathVariable(value = "id") Long id) {
        toppingService.deleteTopping(id);
    }

    @RequestMapping(value = "/toppings", method = RequestMethod.GET)
    public List<Topping> getAllToppings() {
        return toppingService.findAllToppings();
    }

    @RequestMapping(value = "/updateTopping", method = RequestMethod.PUT)
    public Topping updateTopping(@RequestBody Topping topping) {
        Topping existingTopping= toppingService.getById(topping.getId()).get();
        if (existingTopping.getId() != null) {
            topping.setId(existingTopping.getId());
            return toppingService.updateTopping(topping);
        }
        return null;
    }
    @RequestMapping(value = "/findTopping/", method = RequestMethod.GET)
    public Topping findToppingByName(@RequestParam String name) throws JSONException {
        return toppingService.getByName(name);
    }
}
