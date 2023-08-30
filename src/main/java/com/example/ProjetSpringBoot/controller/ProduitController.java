package com.example.ProjetSpringBoot.controller;

import com.example.ProjetSpringBoot.model.Produit;
import com.example.ProjetSpringBoot.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class ProduitController {
    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {

        this.produitService = produitService;
    }



    @PostMapping("/insertNewProduit")
    public void insertProduit(@RequestBody Produit produit) {
        produitService.insertProduit(produit);
    }
    @GetMapping("/Allproduit")
    public List<Produit> getAllProduits() throws SQLException {
        return produitService.findAllProduit();
    }
    @GetMapping("/get/{id_produit}")
    public Produit getProduitById_produit(@PathVariable int id_produit) throws SQLException {
        return produitService.getProduitById(id_produit);
    }
    @PutMapping("/update/{id_produit}")
    public Produit updateProduit(@PathVariable int id_produit, @RequestBody Produit produit) throws SQLException {
        return produitService.updateProduit(produit.getIdProduit(), produit.getNomProduit(), produit.getDescriptionProduit(), produit.getPrixProduit(), produit.getQuantiteProduit());
    }
    @DeleteMapping("/delete/{id_produit}")
    public void deleteProduit(@PathVariable int id_produit) throws SQLException {
        produitService.deleteProduit(id_produit);
    }}

