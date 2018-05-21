package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaRepo extends MongoRepository<Pizza, Long> {
}
