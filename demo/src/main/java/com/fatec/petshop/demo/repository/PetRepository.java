package com.fatec.petshop.demo.repository;

import com.fatec.petshop.demo.domain.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
