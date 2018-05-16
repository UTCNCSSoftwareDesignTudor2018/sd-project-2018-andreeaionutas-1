package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.Administrator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdministratorRepo extends MongoRepository<Administrator, Long> {
}
