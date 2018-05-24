package com.aionutas.pizzaorderingsystem.model.repository;

import com.aionutas.pizzaorderingsystem.model.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepo extends MongoRepository<Client, Long>{
}
