package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Topping;
import com.aionutas.pizzaorderingsystem.model.repository.ToppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = ToppingRepo.class)
@Configuration

public class ToppingService {
    @Autowired
    ToppingRepo toppingRepo;

    public Topping addTopping(Topping topping) {
        return toppingRepo.save(topping);
    }

    public Optional<Topping> getById(Long id) {
        return toppingRepo.findById(id);
    }

    public void deleteTopping(Long id) {
        Topping deleteTopping = toppingRepo.findById(id).get();

        if (deleteTopping.getId() != null) {
            toppingRepo.delete(deleteTopping);
        } else {
            System.out.println("Could not delete topping!");
        }

    }

    public List<Topping> findAllToppings() {
        return toppingRepo.findAll();
    }

    public Topping updateTopping(Topping topping) {
        return toppingRepo.save(topping);
    }


}
