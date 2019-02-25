package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ProduitDTO;
import com.example.demo.services.IProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitController {

	@Autowired
	private IProduitService produitservice;

	@GetMapping
	public List<ProduitDTO> getProduits() {
		return produitservice.getProduits();
	}

	@PostMapping("/add")
	public void addProduit(@RequestBody ProduitDTO produit) {
		produitservice.addProduit(produit);
	}

	@PutMapping("/update")
	public void updateProduit(@RequestBody ProduitDTO produit) {
		produitservice.updateProduit(produit);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduit(@PathVariable long id) {
		produitservice.deleteProduit(id);
	}

}
