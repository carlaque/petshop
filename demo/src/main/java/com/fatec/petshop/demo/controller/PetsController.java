package com.fatec.petshop.demo.controller;

import java.util.List;

import com.fatec.petshop.demo.controller.dto.PetDto;
import com.fatec.petshop.demo.domain.Pet;
import com.fatec.petshop.demo.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public List<PetDto> list(){

        List<Pet> pets = petRepository.findAll();

        return PetDto.converter(pets);
        
    }
    
}
