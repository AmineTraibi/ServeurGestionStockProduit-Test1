package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Produit;
import com.example.demo.Repository.IProduitRepository;

@Service
@Primary
public class ProduitServiceImpl implements IProduitService{

	@Autowired
	private IProduitRepository produit_repository;
	
	@Override
	public List<Produit> getProduits() {
		return produit_repository.findAll();
	}

	@Override
	public void addProduit(Produit produit) {
		produit_repository.save(produit);		
	}

	@Override
	public void updateProduit(Produit produit) {
		produit_repository.save(produit);		
	}

	@Override
	public void deleteProduit(long id) {
		Produit produit=produit_repository.getOne(id);
		produit_repository.delete(produit);
	}

}
