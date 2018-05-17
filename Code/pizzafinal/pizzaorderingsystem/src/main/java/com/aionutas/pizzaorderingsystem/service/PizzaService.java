package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Ingredient;
import com.aionutas.pizzaorderingsystem.model.entity.Pizza;
import com.aionutas.pizzaorderingsystem.model.entity.Topping;
import com.aionutas.pizzaorderingsystem.model.repository.IngredientRepo;
import com.aionutas.pizzaorderingsystem.model.repository.PizzaRepo;
import com.aionutas.pizzaorderingsystem.model.repository.ToppingRepo;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.aionutas.pizzaorderingsystem.model.utils.Converters.getObjectFromJson;

@EnableMongoRepositories(basePackageClasses = PizzaRepo.class)
@Configuration

public class PizzaService {

    @Autowired
    PizzaRepo pizzaRepo;
    @Autowired
    IngredientRepo ingredientRepo;
    @Autowired
    ToppingRepo toppingRepo;
    @Autowired
     IngredientService ingredientService;
    @Autowired
    ToppingService toppingService;
    Random rand = new Random();



    public Pizza addPizza(Pizza pizza) throws JSONException {

        List<Ingredient> ingredients = new ArrayList<>();
        Long price = Long.valueOf(0);
        for (Ingredient ingredient : pizza.getIngredients()) {
            if (ingredientService.getByName(ingredient.getName())!= null) {
                ingredient = ingredientService.getByName(ingredient.getName());
                price = price + ingredient.getPrice();
                ingredients.add(ingredient);
            } else {
                System.out.println("Could not find ingredient");
            }
        }

        List<Topping> toppings = new ArrayList<>();
        if (!pizza.getToppings().isEmpty()) {
            for (Topping topping : pizza.getToppings()) {
                if (toppingService.getByName(topping.getName()) != null) {
                    topping = toppingService.getByName(topping.getName());
                    price = price + topping.getPrice();
                    toppings.add(topping);
                } else {
                    System.out.println("Could not find topping");
                }
            }
        }
        if (!toppings.isEmpty()) {
            pizza.setToppings(toppings);
        }
        pizza.setIngredients(ingredients);
        pizza.setPrice(price);
        return pizzaRepo.save(pizza);
    }


    public Pizza getByName(String name) throws JSONException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("pizzaorderingsystem");
        DBCollection coll = db.getCollection("pizza");
        BasicDBObject query = new BasicDBObject("name", name);
        DBObject cursor = coll.findOne(query);

        Pizza pizza = pizzaRepo.findById(Long.valueOf(cursor.get("_id").toString())).get();


        return pizza;

    }



    public Optional<Pizza> getById(Long id) {
        return pizzaRepo.findById(id);
    }

    public void deletePizza(Long id) {
        Pizza deletePizza = pizzaRepo.findById(id).get();

        if (deletePizza.getId() != null) {
            pizzaRepo.delete(deletePizza);
        } else {
            System.out.println("Could not delete pizza!");
        }

    }

    public List<Pizza> findAllPizzas() {
        return pizzaRepo.findAll();
    }

    public Pizza updatePizza(Pizza pizza) {
        return pizzaRepo.save(pizza);
    }


}
