package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Administrator;
import com.aionutas.pizzaorderingsystem.model.repository.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = AdministratorRepo.class)
@Configuration
public class AdministratorService {

    @Autowired
    AdministratorRepo administratorRepo;

    public Administrator addAdministrator(Administrator administrator) {
        return administratorRepo.save(administrator);
    }

    public Optional<Administrator> getById(Long id) {
        return administratorRepo.findById(id);
    }

    public void deleteAdministrator(Long id) {
        Administrator removeAdmin = administratorRepo.findById(id).get();

        if (removeAdmin.getId() != null) {
            administratorRepo.delete(removeAdmin);
        } else {
            System.out.println("Could not delete administrator!");
        }

    }

    public List<Administrator> findAllAdministrators() {
        return administratorRepo.findAll();
    }

    public Administrator updateAdministrator(Administrator administrator) {
        return administratorRepo.save(administrator);
    }
}
