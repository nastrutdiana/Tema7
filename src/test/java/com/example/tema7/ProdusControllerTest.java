package com.example.tema7;

import com.example.tema7.controller.ProdusController;
import com.example.tema7.model.Produs;
import com.example.tema7.model.Tip;
import com.example.tema7.service.ProdusService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProdusController.class)
public class ProdusControllerTest {
    @MockBean
    ProdusService produsService;
    private Produs produs;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_add_product() throws Exception{
        String request =new String( "{ \"codIdentificare\": \"1\", \"nume\": \"Aragaz\", \"stocInitial\":\"5\", \"tip\":\"ELB\", \"pret\":\"20\"}");
        mockMvc.perform(post("/produse")
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void it_should_get_all_products() throws Exception{
        mockMvc.perform(get("/produse/all"))
                .andExpect(status().isOk());
    }




}
