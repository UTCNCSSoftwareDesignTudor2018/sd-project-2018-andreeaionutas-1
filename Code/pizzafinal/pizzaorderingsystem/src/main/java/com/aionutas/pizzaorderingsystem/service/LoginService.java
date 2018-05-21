package com.aionutas.pizzaorderingsystem.service;


import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.aionutas.pizzaorderingsystem.model.entity.PizzaStore;
import com.aionutas.pizzaorderingsystem.model.repository.ClientRepo;
import com.aionutas.pizzaorderingsystem.model.repository.PizzaRepo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class LoginService {
    @Autowired
    ClientService clientService;
    @Autowired
    PizzaStoreService pizzaStoreService;

    public String getUser(String username, String password) throws JSONException {
        if(!Objects.isNull(clientService.getByUsername(username)) &&!clientService.getByUsername(username).equals(null)){
            Client client = clientService.getByUsername(username);
            if(client.getPassword().equalsIgnoreCase(password))
            {
                return "Is client";
            }
            else return "Not a user";
        }
        else if(pizzaStoreService.getByUsername(username)!= null && !pizzaStoreService.getByUsername(username).equals(null)){
            PizzaStore pizzaStore= pizzaStoreService.getByUsername(username);
            if(pizzaStore.getPassword().equalsIgnoreCase(password))
            {
                return "Is pizza store";
            }
            else return "Not a user";
        }
        else return "Not a user";

    }
}
