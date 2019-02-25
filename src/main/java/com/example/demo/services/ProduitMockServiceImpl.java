package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.ProduitDTO;

@Service
public class ProduitMockServiceImpl implements IProduitService {

    private List<ProduitDTO> produits;

	public ProduitMockServiceImpl() {
		produits = new ArrayList<>();

		produits.add(new ProduitDTO("Livre", 50, 20.5f));
		produits.add(new ProduitDTO("Cahier", 200, 5.25f));
		produits.add(new ProduitDTO("Stylo", 500, 10.25f));
	}

	@Override
	public List<ProduitDTO> getProduits() {
		return produits;
	}

	@Override
	public void addProduit(ProduitDTO produit) {
		produits.add(produit);
	}

	@Override
	public void updateProduit(ProduitDTO produit) {
		for(int i=0;i<produits.size();i++) {
			if(produits.get(i).getRef().equals(produit.getRef())){
				produits.set(i, produit);
			}
		}
	}

	@Override
	public void deleteProduit(long id) {
		for(int i=0;i<produits.size();i++) {
			if(produits.get(i).getId()==id) {
				produits.remove(produits.get(i));
			}
		}
	}

}
