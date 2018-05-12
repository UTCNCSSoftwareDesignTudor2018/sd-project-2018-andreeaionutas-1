package com.aionutas.pizzaorderingsystem.service;

import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.aionutas.pizzaorderingsystem.model.entity.Order;
import com.aionutas.pizzaorderingsystem.model.repository.ClientRepo;
import com.aionutas.pizzaorderingsystem.model.repository.OrderRepo;
import com.aionutas.pizzaorderingsystem.model.utils.OrderStatus;
import com.aionutas.pizzaorderingsystem.model.utils.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

@EnableMongoRepositories(basePackageClasses = ClientRepo.class)
@Configuration
public class ClientService implements Observer {

    @Autowired
    ClientRepo clientRepo;
    @Autowired
    OrderRepo orderRepo;

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

    public String setReadyOrder(Observable o, Object arg) {
        update(o, arg);
        Order order = (Order) arg;
        new Reminder(10);
        order.setOrderStatus(OrderStatus.READY);
        return "Order is ready";
    }

    public String seeStatus(Long id) {
        Order order = orderRepo.findById(id).get();
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
    }
}
