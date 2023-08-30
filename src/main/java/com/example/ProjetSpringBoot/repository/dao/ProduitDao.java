package com.example.ProjetSpringBoot.repository.dao;

import com.example.ProjetSpringBoot.model.Produit;
import com.example.ProjetSpringBoot.repository.inter.ProduitInterface;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProduitDao implements ProduitInterface {
    private Connection connection;

public ProduitDao (Connection connection) {
    this.connection = connection ;
}
    @Override
    public void insertProduit(Produit produit) {
        String query = "INSERT INTO produits (id_produit, nom_produit, description_produit, prix_produit, quatité_produit) values (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, produit.getIdProduit());
            statement.setString(2, produit.getNomProduit());
            statement.setString(3, produit.getDescriptionProduit());
            statement.setInt(4, produit.getPrixProduit());
            statement.setInt(5, produit.getQuantiteProduit());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> findAllProduit() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produits";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
           mapResultSetToProduit(produits,resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produits;

    }


    @Override
    public Produit getById(int id_produit) throws SQLException {
        String sql = "SELECT * FROM produits WHERE id_produit = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id_produit);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new Produit(
                        result.getInt("id_produit"),
                        result.getString("nom_produit"),
                        result.getString("description_produit"),
                        result.getInt("prix_produit"),
                        result.getInt("quatité_produit")
                );
            }
        }
        return null;
    }


    @Override
    public void delete(int id_produit) throws SQLException {
        String sql = "DELETE FROM produits WHERE id_produit = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id_produit);
            preparedStatement.executeUpdate();
        }
    }




    @Override
    public Produit update(int id_produit, String nom_produit, String description_produit, int prix_produit, int quatité_produit) throws SQLException {
        Produit updatedProduit = new Produit(id_produit, nom_produit, description_produit, prix_produit, quatité_produit);
        String sql = "UPDATE produits SET nom_produit = ?, description_produit = ?, prix_produit = ?, quatité_produit = ? WHERE id_produit = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nom_produit);
            preparedStatement.setString(2, description_produit);
            preparedStatement.setInt(3, prix_produit);
            preparedStatement.setInt(4, quatité_produit);
            preparedStatement.setInt(5, id_produit);
            preparedStatement.executeUpdate();
        }
        return updatedProduit;
    }



    private List<Produit> mapResultSetToProduit( List<Produit> produits ,ResultSet resultSet) throws SQLException {
        produits.add(
                new Produit(
                        resultSet.getInt("id_produit"),
                        resultSet.getString("nom_produit"),
                        resultSet.getString("description_produit"),
                        resultSet.getInt("prix_produit"),
                        resultSet.getInt("quatité_produit")
        ));

        return produits;
    }
}
