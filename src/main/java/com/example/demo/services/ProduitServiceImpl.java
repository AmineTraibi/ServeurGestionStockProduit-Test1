package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProduitDTO;
import com.example.demo.repository.IProduitRepository;

@Service
@Primary
public class ProduitServiceImpl implements IProduitService{

	@Autowired
	private IProduitRepository produitRepository;
	
	@Override
	public List<ProduitDTO> getProduits() {
		return produitRepository.findAll();
	}

	@Override
	public void addProduit(ProduitDTO produit) {
		produitRepository.save(produit);		
	}

	@Override
	public void updateProduit(ProduitDTO produit) {
		produitRepository.save(produit);		
	}

	@Override
	public void deleteProduit(long id) {
		ProduitDTO produit=produitRepository.getOne(id);
		produitRepository.delete(produit);
	}

}
