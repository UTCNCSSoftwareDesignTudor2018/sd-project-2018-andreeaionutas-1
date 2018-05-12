package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepo extends MongoRepository<Ingredient, Long> {
}
