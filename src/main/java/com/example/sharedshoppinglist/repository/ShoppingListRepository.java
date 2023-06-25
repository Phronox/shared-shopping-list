package com.example.sharedshoppinglist.repository;

import com.example.sharedshoppinglist.service.ShoppingList;

import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository {

    ShoppingList save(ShoppingList shoppingList);
    Optional<ShoppingList> findById(Long id);
    List<ShoppingList> findAll();
    void deleteById(Long id);

}
