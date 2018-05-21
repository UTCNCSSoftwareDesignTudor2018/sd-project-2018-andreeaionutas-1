package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.Topping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToppingRepo extends MongoRepository<Topping, Long> {
}
