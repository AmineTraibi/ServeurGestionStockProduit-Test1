package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
    //jpa-data offre cette possibilité
	//jpa cree un obljet par defaut apres il commence de set() **constructeur par defaut
	User findByUsername(String str);
}