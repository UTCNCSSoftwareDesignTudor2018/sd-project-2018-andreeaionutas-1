package com.aionutas.pizzaorderingsystem.validators;

import com.aionutas.pizzaorderingsystem.model.entity.Client;

public class NameValidator implements Validator<Client> {
    @Override
    public boolean validate(Client client) {

            return client.getName().matches( "[A-Z][a-zA-Z]*" );

    }
}
