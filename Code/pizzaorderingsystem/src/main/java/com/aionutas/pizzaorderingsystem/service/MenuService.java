
package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Menu;
import com.aionutas.pizzaorderingsystem.model.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = MenuRepo.class)
@Configuration
public class MenuService {

    @Autowired
    MenuRepo menuRepo;

    public Menu addMenu(Menu menu) {
        return menuRepo.save(menu);
    }

    public Optional<Menu> getById(Long id) {
        return menuRepo.findById(id);
    }

    public void deleteMenu(Long id) {
        Menu deleteMenu = menuRepo.findById(id).get();

        if (deleteMenu.getId() != null) {
            menuRepo.delete(deleteMenu);
        } else {
            System.out.println("Could not delete menu!");
        }

    }

    public List<Menu> findAllMenus() {
        return menuRepo.findAll();
    }

    public Menu updateMenu(Menu menu) {
        return menuRepo.save(menu);
    }
}
