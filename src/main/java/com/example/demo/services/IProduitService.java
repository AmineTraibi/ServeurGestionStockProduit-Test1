package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.ProduitDTO;

public interface IProduitService {

	List<ProduitDTO> getProduits();

	void addProduit(ProduitDTO produit);

	void updateProduit(ProduitDTO produit);

	void deleteProduit(long id);
	
}
