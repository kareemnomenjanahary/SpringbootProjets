package com.example.ProjetSpringBoot.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Sortie {
    private Integer idMouvementDeStockSortie;
    private Produit produit;
    private MouvementDeStockSortie mouvementDeStockSortie;
}
