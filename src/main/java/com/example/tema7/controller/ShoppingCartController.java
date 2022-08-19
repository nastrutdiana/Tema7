package com.example.tema7.controller;

import com.example.tema7.model.ShoppingCart;
import com.example.tema7.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PostMapping
    public void createShoppingCart(){
         shoppingCartService.createShoppingCart();
    }

    @PutMapping("add/{productId}/{shoppingId}")
    public void addProduct(@PathVariable Integer productId, @PathVariable Integer shoppingId){
        shoppingCartService.addProduct(productId, shoppingId);
    }

    @DeleteMapping("remove/{productId}/{shoppingId}")
    public void removeProduct(@PathVariable Integer productId, @PathVariable Integer shoppingId){
        shoppingCartService.removeProduct(productId, shoppingId);
    }

    @GetMapping("price/{shoppingCartId}")
    public Integer totalPrice(@PathVariable Integer shoppingCartId){
        return shoppingCartService.totalPrice(shoppingCartId);
    }
}
