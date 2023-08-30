package com.example.ProjetSpringBoot.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Entree {
    private int idMouvementDeStockEntree;
    private Produit produit;
    private MouvementDeStocksEntrée mouvementDeStockEntree;
}
