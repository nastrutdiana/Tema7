package com.example.tema7.repository;

import com.example.tema7.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ProdusRepository extends JpaRepository<Produs, Integer> {
    List<Produs> findAll();
    @Transactional
    @Modifying
    @Query(value = "UPDATE Produs p set p.stocInitial = p.stocInitial + 1 WHERE p.id = :id")
    void incrementStoc(@Param("id") Integer id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Produs p set p.stocInitial = p.stocInitial - 1 WHERE p.id = :id")
    void decrementStoc(@Param("id") Integer id);
}
