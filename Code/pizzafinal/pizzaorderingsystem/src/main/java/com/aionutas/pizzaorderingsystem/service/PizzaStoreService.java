package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Drink;
import com.aionutas.pizzaorderingsystem.model.entity.Pizza;
import com.aionutas.pizzaorderingsystem.model.entity.PizzaStore;
import com.aionutas.pizzaorderingsystem.model.repository.PizzaStoreRepo;
import com.aionutas.pizzaorderingsystem.model.utils.OrderStatus;
import com.mongodb.*;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = PizzaStoreRepo.class)
@Configuration
public class PizzaStoreService {
    @Autowired
    PizzaStoreRepo pizzaStoreRepo;
    @Autowired
    PizzaService pizzaService;
    @Autowired
    DrinkService drinkService;

    public PizzaStore addPizzaStore(PizzaStore pizzaStore) throws JSONException {

        List<Pizza> pizzas = new ArrayList<>();

        for (Pizza pizza : pizzaStore.getPizzas()) {
            if ((pizza.getName() != null && !pizza.getName().isEmpty())) {
                pizza = pizzaService.getByName(pizza.getName());
                pizzas.add(pizza);
            } else {
                System.out.println("Could not find pizza");
            }
        }


        List<Drink> drinks = new ArrayList<>();
        if (!pizzaStore.getDrinks().isEmpty()) {
            for (Drink drink : pizzaStore.getDrinks()) {
                if (drink.getName() != null && !drink.getName().isEmpty() && drinkService.getByName(drink.getName()) != null) {
                    drink = drinkService.getByName(drink.getName());
                    drinks.add(drink);
                } else {
                    System.out.println("Could not find drink");
                }
            }
        }
        if (!drinks.isEmpty()) {
            pizzaStore.setDrinks(drinks);
        }
        pizzaStore.setPizzas(pizzas);


        return pizzaStoreRepo.save(pizzaStore);
    }

    public Optional<PizzaStore> getById(Long id) {
        return pizzaStoreRepo.findById(id);
    }

    public void deletePizzaStore(Long id) {
        PizzaStore deletePizzaStore = pizzaStoreRepo.findById(id).get();

        if (deletePizzaStore.getId() != null) {
            pizzaStoreRepo.delete(deletePizzaStore);
        } else {
            System.out.println("Could not delete pizza store!");
        }

    }

    public List<PizzaStore> findAllPizzaStores() {
        return pizzaStoreRepo.findAll();
    }

    public PizzaStore updatePizzaStore(PizzaStore pizzaStore) {
        return pizzaStoreRepo.save(pizzaStore);
    }


    public PizzaStore getByName(String name) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("pizzaorderingsystem");
        DBCollection coll = db.getCollection("pizzaStore");
        BasicDBObject query = new BasicDBObject("name", name);
        DBObject cursor = coll.findOne(query);

        PizzaStore pizzaStore= pizzaStoreRepo.findById(Long.valueOf(cursor.get("_id").toString())).get();


        return pizzaStore;
    }
}
