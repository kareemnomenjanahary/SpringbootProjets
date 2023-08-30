package com.example.ProjetSpringBoot.model;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MouvementDeStocksEntrée {
    private Integer idMouvementDeStockEntree;
    private Integer quantiteConcerne;
    private Timestamp dateMouvement;
}
