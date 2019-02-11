package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(String name);
}
