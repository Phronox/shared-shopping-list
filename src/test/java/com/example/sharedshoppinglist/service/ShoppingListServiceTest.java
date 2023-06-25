package com.example.sharedshoppinglist.service;

import com.example.sharedshoppinglist.repository.ShoppingListRepositoryInMemoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingListServiceTest {
    ShoppingListService shoppingListService;
    @BeforeEach
    void setUp(){
        shoppingListService = new ShoppingListService(new ShoppingListRepositoryInMemoryImpl());
    }

    @Test
    void when_existingShoppingListSearched_thenReturnShoppingList(){
        long id = 12L;
        ShoppingList sl = new ShoppingList(12L, "shoppingList",null);
        shoppingListService.saveShoppingList(sl);

        assertEquals(shoppingListService.getShoppingList(id), sl);
    }

    @Test
    void when_existingShoppingListDeleted_thenCannotBeFoundAnymore(){
        long id = 12L;
        ShoppingList sl = new ShoppingList(12L, "shoppingList",null);
        shoppingListService.saveShoppingList(sl);
        shoppingListService.deleteShoppingList(id);

        assertThrows(RuntimeException.class, ()->shoppingListService.getShoppingList(id));

    }

}
