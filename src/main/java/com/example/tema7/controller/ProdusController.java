package com.example.tema7.controller;

import com.example.tema7.model.Produs;
import com.example.tema7.service.ProdusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("produse")
public class ProdusController {

    private final ProdusService produsService;

    @GetMapping("/all")
    public List<Produs> getAll(){
        return produsService.getAll();
    }

    @GetMapping
    public List<Produs> getAllNoDeleted(){
        return produsService.getAllNoDeleted();
    }

    @PostMapping
    public void adaugareProdus(@RequestBody Produs produs){
        produsService.insert(produs);
    }

    @PutMapping("increment/{id}")
    public void incrementProdus(@PathVariable Integer id){
        produsService.incrementProdus(id);
    }
    @PutMapping("decrement/{id}")
    public void decrementProdus(@PathVariable Integer id){
        produsService.decrementProdus(id);
    }
    @DeleteMapping("{id}")
    public void deleteProdus(@PathVariable Integer id){
        produsService.delete(id);
    }
    @PutMapping("/actualizareStoc/{id}/{stoc}")
    public void actualizareStoc(@PathVariable Integer id,@PathVariable Integer stoc){
        produsService.actualizareStoc(id, stoc);
    }
}
