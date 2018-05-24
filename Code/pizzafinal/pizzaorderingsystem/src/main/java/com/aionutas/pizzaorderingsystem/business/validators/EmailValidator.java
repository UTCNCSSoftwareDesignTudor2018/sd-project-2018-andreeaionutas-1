package com.aionutas.pizzaorderingsystem.validators;

import com.aionutas.pizzaorderingsystem.model.entity.Client;

public class EmailValidator implements Validator<Client> {
    @Override
    public boolean validate(Client client) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        if (client.getEmail().matches(ePattern)) {
            return true;
        } else
            return false;
    }
}
