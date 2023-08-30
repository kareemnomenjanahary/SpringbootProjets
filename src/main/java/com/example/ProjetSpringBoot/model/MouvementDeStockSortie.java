package com.example.ProjetSpringBoot.model;

import lombok.*;

import java.sql.Timestamp;
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MouvementDeStockSortie {
    private Integer idMouvementDeStockSortie;
    private Integer quantiteConcerne;
    private Timestamp dateMouvement;

}
