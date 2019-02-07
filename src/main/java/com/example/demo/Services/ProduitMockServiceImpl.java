package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.Produit;

@Service
public class ProduitMockServiceImpl implements IProduitService {

    private List<Produit> produits;

	public ProduitMockServiceImpl() {
		produits = new ArrayList<Produit>();

		produits.add(new Produit("Livre", 50, 20.5f));
		produits.add(new Produit("Cahier", 200, 5.25f));
		produits.add(new Produit("Stylo", 500, 10.25f));
	}

	@Override
	public List<Produit> getProduits() {
		return produits;
	}

	@Override
	public void addProduit(Produit produit) {
		produits.add(produit);
	}

	@Override
	public void updateProduit(Produit produit) {
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
