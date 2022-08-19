package com.example.tema7;

import com.example.tema7.model.Produs;
import com.example.tema7.model.ShoppingCart;
import com.example.tema7.model.Tip;
import com.example.tema7.repository.ProdusRepository;
import com.example.tema7.repository.ShoppingCartRepository;
import com.example.tema7.service.ProdusService;
import com.example.tema7.service.ShoppingCartService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {
    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @Mock
    ProdusRepository produsRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @InjectMocks
    ProdusService produsService;

    @Test
    public void when_save_cart(){
        when(shoppingCartRepository.save(any(ShoppingCart.class))).thenReturn(new ShoppingCart());
        ShoppingCart shoppingCart = shoppingCartService.createShoppingCart();

    }

    @Test
    public void when_add_product(){

        Produs p = new Produs();
        p.setId(1);
        when(produsRepository.save(any(Produs.class))).thenReturn(new Produs());
        produsService.insert(p);
        when(shoppingCartRepository.save(any(ShoppingCart.class))).thenReturn(new ShoppingCart());
        ShoppingCart s = shoppingCartService.createShoppingCart();
        s.setId(1);
        shoppingCartService.addProduct(p.getId(),s.getId());
        Assert.assertEquals(s.getProduse(), p);
        //Assert.assertFalse(s.getProduse().isEmpty());

    }
}
