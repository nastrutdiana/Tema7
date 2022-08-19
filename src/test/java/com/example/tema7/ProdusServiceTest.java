package com.example.tema7;

import com.example.tema7.model.Produs;
import com.example.tema7.repository.ProdusRepository;
import com.example.tema7.service.ProdusService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProdusServiceTest {
    @Mock
    ProdusRepository produsRepository;

    @InjectMocks
    ProdusService produsService;

    @Test
    public void when_save_product_it_should_return_product(){
        Produs produs = new Produs();
        produs.setNume("test");
        when(produsRepository.save(any(Produs.class))).thenReturn(new Produs());
        produsService.insert(produs);
        assertThat(produs.getNume()).isSameAs("test");

    }
}
