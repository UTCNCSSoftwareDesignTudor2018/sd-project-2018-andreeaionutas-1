package com.aionutas.pizzaorderingsystem.controller;

import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.aionutas.pizzaorderingsystem.service.ClientService;
import com.aionutas.pizzaorderingsystem.service.OrderService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    OrderService orderService;

    Random rand = new Random();

    @RequestMapping(value = "/findClient/{id}", method = RequestMethod.GET)
    public Client findClientById(@PathVariable Long id) {
        return clientService.getById(id).get();
    }


    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public Client addClient(@RequestBody Client client) {
        client.setId(Long.valueOf(rand.nextInt(1000)));
        if(!clientService.getById(client.getId()).isPresent()){
            return clientService.addClient(client);}
        else return null;
    }

    @RequestMapping(value = "/findClient/", method = RequestMethod.GET)
    public Client findClientByName(@RequestParam String name) throws JSONException {
        return clientService.getByName(name);
    }

    @RequestMapping(value = "/findOrderStatus/", method = RequestMethod.GET)
    public String getOrderStatus(Long id) throws InterruptedException {
        return clientService.seeStatus(id);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable(value = "id") Long id) {
        clientService.deleteClient(id);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @RequestMapping(value = "/updateClientAccount", method = RequestMethod.PUT)
    public Client updateClient(@RequestBody Client client) {
        Client existingclient = clientService.getById(client.getId()).get();
        if (existingclient.getId() != null) {
            client.setId(existingclient.getId());
            return clientService.updateClient(client);
        }
        return null;
    }

    @RequestMapping(value = "/seeOrderStatus/{id}", method = RequestMethod.GET)
    public String seeStatus(@PathVariable  Long id) throws InterruptedException {
        if(orderService.getById(id).get() != null) {
            return clientService.seeStatus(id);
        }
        return null;
    }

}
