package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.Entities.Produit;
import com.example.demo.Entities.Role;
import com.example.demo.Entities.User;
import com.example.demo.Repository.IProduitRepository;
import com.example.demo.Repository.IRoleRepository;
import com.example.demo.Repository.IUserRepository;

@SpringBootApplication
public class ServeurGestionStockProduitTest1Application {

	public static void main(String[] args) {
		
        ConfigurableApplicationContext ctx = SpringApplication.run(ServeurGestionStockProduitTest1Application.class, args);
		
		
		  IProduitRepository produitRepository = ctx.getBean(IProduitRepository.class);
		  
		  produitRepository.save(new Produit("Livre", 50, 2000));
		  produitRepository.save(new Produit("Cahier", 200, 5.25f));
		  produitRepository.save(new Produit("Stylo", 500, 2.10f));
		  produitRepository.save(new Produit("Cartable", 500, 50f));
		  produitRepository.save(new Produit("Marqueur", 350, 2.10f));
		 
		  IRoleRepository roleRepository = ctx.getBean(IRoleRepository.class);
			
			Role roleUser = new Role("ROLE_USER");
			Role roleAdmin = new Role("ROLE_ADMIN");
			roleRepository.save(roleUser);
			roleRepository.save(roleAdmin);
			
			
			IUserRepository userRepository = ctx.getBean(IUserRepository.class);
			
			User user = new User("user", "user", true);
			user.setRoles(Arrays.asList(roleUser));
			userRepository.save(user);
			
			User user1 = new User("amin", "123", true);
			user1.setRoles(Arrays.asList(roleUser));
			userRepository.save(user1);

			
			User admin = new User("admin", "admin", true);
			admin.setRoles(Arrays.asList(roleUser, roleAdmin));
			userRepository.save(admin);
			
		 
        }

}

