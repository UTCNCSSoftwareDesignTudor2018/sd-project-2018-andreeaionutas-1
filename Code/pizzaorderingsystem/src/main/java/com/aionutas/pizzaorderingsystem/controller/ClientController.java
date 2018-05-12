package com.aionutas.pizzaorderingsystem.controller;

import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.aionutas.pizzaorderingsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/findClient/{id}", method = RequestMethod.GET)
    public Client findClientById(@PathVariable Long id) {
        return clientService.getById(id).get();
    }


    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public Client addClient(@RequestBody Client client) {
        if(!clientService.getById(client.getId()).isPresent()){
            return clientService.addClient(client);}
        else return null;
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


}
