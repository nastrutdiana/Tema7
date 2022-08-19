package com.example.tema7.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produs {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String codIdentificare;
    @NotNull
    private String nume;
    private Integer stocInitial;
    private boolean deleted = false;
    private Tip tip;
    private Integer pret;

}
