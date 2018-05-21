package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepo extends MongoRepository<Menu, Long> {
}
