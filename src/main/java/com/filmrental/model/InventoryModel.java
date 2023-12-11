package com.filmrental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryModel {
    private int inventoryId;
    private FilmModel film;
    private StoreModel store;
//    private int filmCount;
}
