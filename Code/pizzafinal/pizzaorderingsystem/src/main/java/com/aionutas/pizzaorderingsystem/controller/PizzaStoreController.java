package com.aionutas.pizzaorderingsystem.controller;


import com.aionutas.pizzaorderingsystem.model.entity.Pizza;
import com.aionutas.pizzaorderingsystem.model.entity.PizzaStore;
import com.aionutas.pizzaorderingsystem.service.PizzaStoreService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/pizzaStores")

public class PizzaStoreController {
    @Autowired
    PizzaStoreService pizzaStoreService;
    Random rand = new Random();

    @RequestMapping(value = "/findPizzaStore/{id}", method = RequestMethod.GET)
    public PizzaStore findPizzaStoreById(@PathVariable Long id) {
        return pizzaStoreService.getById(id).get();
    }


    @RequestMapping(value = "/addPizzaStore", method = RequestMethod.POST)
    public PizzaStore addPizzaStore(@RequestBody PizzaStore pizzaStore) throws JSONException {
        pizzaStore.setId(Long.valueOf(rand.nextInt(1000)));
        if (!pizzaStoreService.getById(pizzaStore.getId()).isPresent()) {

            return pizzaStoreService.addPizzaStore(pizzaStore);
        } else return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePizzaStore(@PathVariable(value = "id") Long id) {
        pizzaStoreService.deletePizzaStore(id);
    }

    @RequestMapping(value = "/pizzaStores", method = RequestMethod.GET)
    public List<PizzaStore> getAllPizzaStores() {
        return pizzaStoreService.findAllPizzaStores();
    }

    @RequestMapping(value = "/findPizzaStoreByName/", method = RequestMethod.GET)
    public PizzaStore findPizzaName(@RequestParam String name) throws JSONException {
        return pizzaStoreService.getByName(name);
    }

}
