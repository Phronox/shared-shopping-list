package com.example.sharedshoppinglist.web;

import com.example.sharedshoppinglist.service.ShoppingList;
import com.example.sharedshoppinglist.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @PostMapping("/shopping-lists")
    public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.saveShoppingList(shoppingList);
    }

    @GetMapping("/shopping-lists/{id}")
    public ShoppingList getShoppingList(@PathVariable Long id) {
        return shoppingListService.getShoppingList(id);
    }

    @GetMapping("/shopping-lists")
    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListService.getAllShoppingLists();
    }

    @DeleteMapping("/shopping-lists/{id}")
    public void deleteShoppingList(@PathVariable Long id) {
        shoppingListService.deleteShoppingList(id);
    }
}