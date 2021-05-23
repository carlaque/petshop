package com.fatec.petshop.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String raca;

    public Pet() {
    }

    // public Pet(Long id, String name, String raca) {
    //     this.id = id;
    //     this.name = name;
    //     this.raca = raca;
    // }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

}
