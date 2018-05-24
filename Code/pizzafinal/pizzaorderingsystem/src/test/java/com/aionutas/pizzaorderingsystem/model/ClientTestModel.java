package com.aionutas.pizzaorderingsystem.model;

import com.aionutas.pizzaorderingsystem.model.entity.Client;


import java.util.ArrayList;
import java.util.List;

public class ClientTestModel {
    public static List<Client> createClientList(){
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(Long.valueOf(1), "Andreea Ionutas", "andreeaionutas@gmail.com",
               Long.valueOf(7324562), "aionutas", "aionutas"
                ));
        return clientList;
    }

    public static Client createClient(){
        return new Client(Long.valueOf(1), "Andreea Ionutas", "andreeaionutas@gmail.com",
                Long.valueOf(7324562), "aionutas", "aionutas"
        );
    }

}
