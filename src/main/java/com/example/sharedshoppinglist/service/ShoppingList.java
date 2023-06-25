package com.example.sharedshoppinglist.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
public class ShoppingList {
    private Long id;

    private String name;

    private Set<ShoppingListItem> items = new HashSet<>();


}
