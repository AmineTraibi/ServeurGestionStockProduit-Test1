package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.Produit;

public interface IProduitService {

	List<Produit> getProduits();

	void addProduit(Produit produit);

	void updateProduit(Produit produit);

	void deleteProduit(String ref);
}
