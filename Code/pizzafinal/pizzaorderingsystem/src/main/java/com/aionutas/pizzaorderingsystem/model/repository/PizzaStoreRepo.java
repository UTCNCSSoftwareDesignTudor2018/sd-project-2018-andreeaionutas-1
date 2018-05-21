package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.PizzaStore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaStoreRepo extends MongoRepository<PizzaStore, Long> {
}
