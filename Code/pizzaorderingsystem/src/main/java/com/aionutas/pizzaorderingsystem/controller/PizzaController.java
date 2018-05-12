package com.aionutas.pizzaorderingsystem.controller;


import com.aionutas.pizzaorderingsystem.model.entity.Pizza;
import com.aionutas.pizzaorderingsystem.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    @RequestMapping(value = "/findPizza/{id}", method = RequestMethod.GET)
    public Pizza findPizzaById(@PathVariable Long id) {
        return pizzaService.getById(id).get();
    }


    @RequestMapping(value = "/addPizza", method = RequestMethod.POST)
    public Pizza addPizza(@RequestBody Pizza pizza) {
        if(!pizzaService.getById(pizza.getId()).isPresent()){
            return pizzaService.addPizza(pizza);}
        else return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePizza(@PathVariable(value = "id") Long id) {
        pizzaService.deletePizza(id);
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public List<Pizza> getAllPizzas() {
        return pizzaService.findAllPizzas();
    }

    @RequestMapping(value = "/updatePizza", method = RequestMethod.PUT)
    public Pizza updatePizza(@RequestBody Pizza pizza) {
        Pizza existingPizza= pizzaService.getById(pizza.getId()).get();
        if (existingPizza.getId() != null) {
            pizza.setId(existingPizza.getId());
            return pizzaService.updatePizza(pizza);
        }
        return null;
    }
}
