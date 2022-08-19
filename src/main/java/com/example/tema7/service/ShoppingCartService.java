package com.example.tema7.service;

import com.example.tema7.model.Produs;
import com.example.tema7.model.ShoppingCart;
import com.example.tema7.repository.ProdusRepository;
import com.example.tema7.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProdusRepository produsRepository;

    public ShoppingCart createShoppingCart(){
        ShoppingCart sc = new ShoppingCart();
        shoppingCartRepository.save(sc);
        return sc;
    }

    public void addProduct(Integer productId, Integer cartId){
        Produs p = produsRepository.findById(productId).get();
        ShoppingCart s = shoppingCartRepository.findById(cartId).get();
        s.addProduct(p);
    }

    public void removeProduct(Integer productId, Integer cartId){
        Produs p = produsRepository.findById(productId).get();
        ShoppingCart s = shoppingCartRepository.findById(cartId).get();
        s.removeProduct(p);
    }

    public Integer totalPrice(Integer cartId){
        ShoppingCart s = shoppingCartRepository.findById(cartId).get();
        return s.totalPrice();
    }
}
