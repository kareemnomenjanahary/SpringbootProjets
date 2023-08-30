package com.example.ProjetSpringBoot.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Produit {
    private int idProduit;
    private String nomProduit;
    private String descriptionProduit;
    private int  prixProduit;
    private int quantiteProduit;
}
