package com.aionutas.pizzaorderingsystem;

import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.aionutas.pizzaorderingsystem.model.entity.Ingredient;
import com.aionutas.pizzaorderingsystem.service.ClientService;
import com.aionutas.pizzaorderingsystem.service.IngredientService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.aionutas.pizzaorderingsystem.model.ClientTestModel.createClient;
import static com.aionutas.pizzaorderingsystem.model.IngredientTestModel.createIngredient;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class PizzaOrderingSystemTests {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    ClientService clientService;

    @Mock
    IngredientService ingredientService;

    @Test
    @Ignore
    public void shouldReturnClient(){
        Client client= createClient();
        when(clientService.getById(Long.valueOf(1)).get()).thenReturn(client);
        assertTrue(clientService.getById(Long.valueOf(1)).get().equals(client));
    }


    @Test
    @Ignore
    public void shouldReturnIngredient(){
        Ingredient ingredient = createIngredient();
        when(ingredientService.getById(Long.valueOf(178)).get()).thenReturn(ingredient);
        assertTrue(ingredientService.getById(Long.valueOf(178)).get().equals(ingredient));
    }



}
