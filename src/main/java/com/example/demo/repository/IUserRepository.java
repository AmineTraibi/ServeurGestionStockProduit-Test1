package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserDTO;

@Repository
public interface IUserRepository extends JpaRepository<UserDTO, Long>{
    //jpa-data offre cette possibilité
	//jpa cree un obljet par defaut apres il commence de set() **constructeur par defaut
	UserDTO findByUsername(String str);
}