package com.example.sharedshoppinglist.service;

import com.example.sharedshoppinglist.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingList saveShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList getShoppingList(Long id) {
        return shoppingListRepository.findById(id).orElseThrow(() -> new RuntimeException("Shopping list not found"));
    }

    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListRepository.findAll();
    }

    public void deleteShoppingList(Long id) {
        shoppingListRepository.deleteById(id);
    }

}
