package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.Drink;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrinkRepo extends MongoRepository<Drink, Long> {
}
