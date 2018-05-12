package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Pizza;
import com.aionutas.pizzaorderingsystem.model.repository.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = PizzaRepo.class)
@Configuration

public class PizzaService {

    @Autowired
    PizzaRepo pizzaRepo;

    public Pizza addPizza(Pizza pizza) {
        return pizzaRepo.save(pizza);
    }

    public Optional<Pizza> getById(Long id) {
        return pizzaRepo.findById(id);
    }

    public void deletePizza(Long id) {
        Pizza deletePizza = pizzaRepo.findById(id).get();

        if (deletePizza.getId() != null) {
            pizzaRepo.delete(deletePizza);
        } else {
            System.out.println("Could not delete pizza!");
        }

    }

    public List<Pizza> findAllPizzas() {
        return pizzaRepo.findAll();
    }

    public Pizza updatePizza(Pizza pizza) {
        return pizzaRepo.save(pizza);
    }


}
