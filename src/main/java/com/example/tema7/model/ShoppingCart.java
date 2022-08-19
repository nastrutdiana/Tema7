package com.example.tema7.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private List<Produs> produse;

    public Integer totalPrice(){
        Integer sum = 0;
        for(Produs p : produse){
            sum += p.getPret();
        }
        return sum;
    }

    public void addProduct(Produs p){
        produse.add(p);
    }

    public void removeProduct(Produs p){
        produse.remove(p);
    }
}
