package com.aionutas.pizzaorderingsystem;


import com.aionutas.pizzaorderingsystem.model.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static com.aionutas.pizzaorderingsystem.model.ClientTestModel.createClient;
import static com.aionutas.pizzaorderingsystem.model.ClientTestModel.createClientList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMock() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void shouldGetClients() throws Exception {
        List<Client> clientList = createClientList();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(clientList);

        mockMvc.perform(get("/clients/clients"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonInString))
                .andReturn().getResponse().getContentAsString();

    }

    @Test
    public void shouldGetClientById() throws Exception {
        Client client = createClient();
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(client);

        mockMvc.perform(get("/clients/findClient/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonInString))
                .andReturn().getResponse().getContentAsString();
    }

}
