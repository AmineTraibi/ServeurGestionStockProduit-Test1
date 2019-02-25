package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entities.ProduitDTO;
import com.example.demo.entities.RoleDTO;
import com.example.demo.entities.UserDTO;
import com.example.demo.repository.IProduitRepository;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;

@SpringBootApplication
public class ServeurGestionStockProduitTest1Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(ServeurGestionStockProduitTest1Application.class,
				args);

		IProduitRepository produitRepository = ctx.getBean(IProduitRepository.class);

		produitRepository.save(new ProduitDTO("Livre", 50, 2000));
		produitRepository.save(new ProduitDTO("Cahier", 200, 5.25f));
		produitRepository.save(new ProduitDTO("Stylo", 500, 2.10f));
		produitRepository.save(new ProduitDTO("Cartable", 500, 50f));
		produitRepository.save(new ProduitDTO("Marqueur", 350, 2.10f));

		IRoleRepository roleRepository = ctx.getBean(IRoleRepository.class);

		RoleDTO roleUser = new RoleDTO("ROLE_USER");
		RoleDTO roleAdmin = new RoleDTO("ROLE_ADMIN");
		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);

		IUserRepository userRepository = ctx.getBean(IUserRepository.class);

		UserDTO user = new UserDTO("user", "user", true);
		user.setRoles(Arrays.asList(roleUser));
		userRepository.save(user);

		UserDTO user1 = new UserDTO("amin", "123", true);
		user1.setRoles(Arrays.asList(roleUser));
		userRepository.save(user1);

		UserDTO admin = new UserDTO("admin", "admin", true);
		admin.setRoles(Arrays.asList(roleUser, roleAdmin));
		userRepository.save(admin);

	}

}
