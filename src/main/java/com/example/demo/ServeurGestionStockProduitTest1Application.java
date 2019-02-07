package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.Entities.Produit;
import com.example.demo.Repository.IProduitRepository;

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
		 
        }

}

