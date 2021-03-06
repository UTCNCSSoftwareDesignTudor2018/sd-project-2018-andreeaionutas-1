package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.aionutas.pizzaorderingsystem.model.entity.Order;
import com.aionutas.pizzaorderingsystem.model.repository.ClientRepo;
import com.aionutas.pizzaorderingsystem.model.repository.OrderRepo;
import com.aionutas.pizzaorderingsystem.model.utils.OrderStatus;
import com.mongodb.*;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.*;

@EnableMongoRepositories(basePackageClasses = ClientRepo.class)
@Configuration
public class ClientService implements Observer {

    @Autowired
    ClientRepo clientRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderService orderService;

    public Client addClient(Client client) {

        return clientRepo.save(client);
    }

    public Optional<Client> getById(Long id) {
        return clientRepo.findById(id);
    }

    public void deleteClient(Long id) {
        Client deleteClient = clientRepo.findById(id).get();

        if (deleteClient.getId() != null) {
            clientRepo.delete(deleteClient);
        } else {
            System.out.println("Could not delete client!");
        }

    }

    public List<Client> findAllClients() {
        return clientRepo.findAll();
    }

    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    public void setReadyOrder(Observable o, Object arg) throws InterruptedException {
        update(o, arg);
        Order order = (Order) arg;
        System.out.println("Order has been processed");
        Thread.sleep(10000);
        order.setOrderStatus(OrderStatus.READY);
        System.out.println("Order is ready to be picked up");

    }

    public String seeStatus(Long id) throws InterruptedException {

        Order order = orderRepo.findById(id).get();
        setReadyOrder(orderService, order);
        if (order != null && order.getOrderStatus().equals(OrderStatus.PROCESSED)) {
            System.out.println("Order has been processed");
            return "Order has been processed";
        } else if (order != null && order.getOrderStatus().equals(OrderStatus.READY)) {
            System.out.println("Order is ready to be picked up");
            return "Order is ready to be picked up";
        } else return "Could not find order details";
    }

    @Override
    public void update(Observable o, Object arg) {
        Order order = (Order) arg;
        System.out.println("Your order with id: " + order.getId() + " is processed. " + " Total: " + order.getTotal());
    }

    public Client getByName(String name) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("pizzaorderingsystem");
        DBCollection coll = db.getCollection("client");
        BasicDBObject query = new BasicDBObject("name", name);
        DBObject cursor = coll.findOne(query);

        Client client = clientRepo.findById(Long.valueOf(cursor.get("_id").toString())).get();


        return client;
    }

    public Client getByUsername(String name) throws JSONException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("pizzaorderingsystem");
        DBCollection coll = db.getCollection("client");
        BasicDBObject query = new BasicDBObject("username", name);
        DBObject cursor = coll.findOne(query);
        if (!Objects.isNull(cursor) && cursor != null) {
            if (!Objects.isNull(clientRepo.findById(Long.valueOf(cursor.get("_id").toString())).get())) {
                return clientRepo.findById(Long.valueOf(cursor.get("_id").toString())).get();
            }
        }
        return null;

    }
}
