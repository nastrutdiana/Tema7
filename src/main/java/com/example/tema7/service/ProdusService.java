package com.example.tema7.service;

import com.example.tema7.model.Produs;
import com.example.tema7.repository.ProdusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdusService {
    private final ProdusRepository produsRepository;

    public List<Produs> getAll(){
        return produsRepository.findAll();
    }
    public List<Produs> getAllNoDeleted(){
        return getAll().stream().filter(produs -> !produs.isDeleted()).collect(Collectors.toList());
    }

    public void insert(Produs produs){
        produsRepository.save(produs);
    }

    public void incrementProdus(Integer id){
        produsRepository.incrementStoc(id);

//        Produs produs = produsRepository.findById(id);
//        produs.setStocInitial(produs.getStocInitial() + 1);
//        produsRepository.save(produs);

    }

    public void decrementProdus(Integer id){
        produsRepository.decrementStoc(id);

//        Produs produs = produsRepository.findById(id);
//        produs.setStocInitial(produs.getStocInitial() - 1);
//        produsRepository.save(produs);
    }

    public void delete(Integer id){
        Produs p = produsRepository.findById(id).get();
        p.setDeleted(true);
        produsRepository.save(p);
    }

    public void actualizareStoc(Integer id, Integer stoc){
        Produs p = produsRepository.findById(id).get();
        p.setStocInitial(stoc);
        produsRepository.save(p);
    }
}
