package com.aionutas.pizzaorderingsystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Menu {

    private List<Pizza> pizzas;


}
