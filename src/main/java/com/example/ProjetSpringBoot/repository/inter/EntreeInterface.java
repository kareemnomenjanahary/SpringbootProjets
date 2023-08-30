package com.example.ProjetSpringBoot.repository.inter;

import com.example.ProjetSpringBoot.model.MouvementDeStocksEntrée;
import com.example.ProjetSpringBoot.model.Produit;

import java.sql.SQLException;
import java.util.List;

public interface EntreeInterface {
    void insertEntree(Produit produit);
    List<Produit> findAllEntree() throws SQLException;

    Produit getById(int id_entree) throws SQLException;

    void delete(int id_entree) throws SQLException;
    Produit update( int id_entree, Produit produit,MouvementDeStocksEntrée mouvementDeStockEntree) throws SQLException;
}
