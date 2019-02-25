package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ProduitDTO;

@Repository
public interface IProduitRepository extends JpaRepository<ProduitDTO, Long>{

}
