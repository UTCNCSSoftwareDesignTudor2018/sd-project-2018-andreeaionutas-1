package com.aionutas.pizzaorderingsystem.service;


import com.aionutas.pizzaorderingsystem.model.entity.Drink;
import com.aionutas.pizzaorderingsystem.model.repository.DrinkRepo;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = DrinkRepo.class)
@Configuration
public class DrinkService {
    @Autowired
    DrinkRepo drinkRepo;

    public Drink addDrink(Drink drink) {
        return drinkRepo.save(drink);
    }

    public Optional<Drink> getById(Long id) {
        return drinkRepo.findById(id);
    }

    public void deleteDrink(Long id) {
        Drink deleteDrink = drinkRepo.findById(id).get();

        if (deleteDrink.getId() != null) {
            drinkRepo.delete(deleteDrink);
        } else {
            System.out.println("Could not delete drink!");
        }

    }

    public List<Drink> findAllDrinks() {
        return drinkRepo.findAll();
    }

    public Drink updateDrink(Drink drink) {
        return drinkRepo.save(drink);
    }

    public Drink getByName(String name) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("pizzaorderingsystem");
        DBCollection coll = db.getCollection("drink");
        BasicDBObject query = new BasicDBObject("name", name);
        DBObject cursor = coll.findOne(query);

        Drink drink = drinkRepo.findById(Long.valueOf(cursor.get("_id").toString())).get();


        return drink;
    }
}
