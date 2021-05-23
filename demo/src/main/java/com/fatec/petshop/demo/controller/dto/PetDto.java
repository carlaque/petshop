package com.fatec.petshop.demo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fatec.petshop.demo.domain.Pet;

public class PetDto {

    private Long id ;
    private String nome;
    private String raca;


    public PetDto(Pet pet) {
        this.id = pet.getId();
        this.nome = pet.getNome();
        this.raca = pet.getRaca();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return this.raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public static List<PetDto> converter(List<Pet> pets) {
		return pets.stream().map(PetDto::new).collect(Collectors.toList());
	}

}
