package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Ingredient;
import com.aionutas.pizzaorderingsystem.model.repository.ClientRepo;
import com.aionutas.pizzaorderingsystem.model.repository.IngredientRepo;
import com.mongodb.*;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@EnableMongoRepositories(basePackageClasses = IngredientRepo.class)
@Configuration
public class IngredientService {

    Random rand = new Random();


    @Autowired
    IngredientRepo ingredientRepo;

    public Ingredient addIngredient(Ingredient ingredient) {

        return ingredientRepo.save(ingredient);
    }

    public Optional<Ingredient> getById(Long id) {
        return ingredientRepo.findById(id);
    }

    public void deleteIngredient(Long id) {
        Ingredient deleteIngredient = ingredientRepo.findById(id).get();

        if (deleteIngredient.getId() != null) {
            ingredientRepo.delete(deleteIngredient);
        } else {
            System.out.println("Could not delete ingredient!");
        }

    }

    public List<Ingredient> findAllIngredients() {
        return ingredientRepo.findAll();
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    public Ingredient getByName(String name) throws JSONException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("pizzaorderingsystem");
        DBCollection coll = db.getCollection("ingredient");
        BasicDBObject query = new BasicDBObject("name", name);
        DBObject cursor = coll.findOne(query);

        Ingredient ingredient= ingredientRepo.findById(Long.valueOf(cursor.get("_id").toString())).get();


        return ingredient;

    }
}
