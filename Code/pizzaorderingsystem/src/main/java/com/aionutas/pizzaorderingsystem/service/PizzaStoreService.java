package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.PizzaStore;
import com.aionutas.pizzaorderingsystem.model.repository.PizzaStoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = PizzaStoreRepo.class)
@Configuration
public class PizzaStoreService {
    @Autowired
    PizzaStoreRepo pizzaStoreRepo;

    public PizzaStore addPizzaStore(PizzaStore pizzaStore) {
        return pizzaStoreRepo.save(pizzaStore);
    }

    public Optional<PizzaStore> getById(Long id) {
        return pizzaStoreRepo.findById(id);
    }

    public void deletePizzaStore(Long id) {
        PizzaStore deletePizzaStore = pizzaStoreRepo.findById(id).get();

        if (deletePizzaStore.getId() != null) {
            pizzaStoreRepo.delete(deletePizzaStore);
        } else {
            System.out.println("Could not delete pizza store!");
        }

    }

    public List<PizzaStore> findAllPizzas() {
        return pizzaStoreRepo.findAll();
    }

    public PizzaStore updatePizzaStore(PizzaStore pizzaStore) {
        return pizzaStoreRepo.save(pizzaStore);
    }



}
