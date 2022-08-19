package com.example.tema7;

import com.example.tema7.controller.ShoppingCartController;
import com.example.tema7.model.Tip;
import com.example.tema7.service.ShoppingCartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {
    @MockBean
    ShoppingCartService shoppingCartService;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_add_product() throws Exception{
        String request =new String( "{ \"codIdentificare\": \"1\", \"nume\": \"Aragaz\", \"stocInitial\":\"5\", \"tip\":\"ELB\", \"pret\":\"20\"}");
        mockMvc.perform(post("/cart")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
