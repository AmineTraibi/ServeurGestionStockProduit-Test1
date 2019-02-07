package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Produit;
import com.example.demo.Services.IProduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ProduitController {

	@Autowired
	private IProduitService produitservice;

	@GetMapping
	public List<Produit> getProduits() {
		return produitservice.getProduits();
	}

	@PostMapping("/add")
	public void addProduit(@RequestBody Produit produit) {
		produitservice.addProduit(produit);
	}

	@PutMapping("/update")
	public void updateProduit(@RequestBody Produit produit) {
		produitservice.updateProduit(produit);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduit(@PathVariable long id) {
		produitservice.deleteProduit(id);
	}

}
