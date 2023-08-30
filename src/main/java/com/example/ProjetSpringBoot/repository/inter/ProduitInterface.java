package com.example.ProjetSpringBoot.repository.inter;

import java.sql.SQLException;
import java.util.List;

import com.example.ProjetSpringBoot.model.Produit;

public interface ProduitInterface {
    void insertProduit(Produit produit);
    List<Produit> findAllProduit() throws SQLException;

    Produit getById(int id_produit) throws SQLException;

    void delete(int id_produit) throws SQLException;
    Produit update( int id_produit, String nom_produit,String description_produit,int prix_produit,int quatité_produit) throws SQLException;
}
