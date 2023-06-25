package com.example.sharedshoppinglist.repository;

import com.example.sharedshoppinglist.service.ShoppingList;
import com.example.sharedshoppinglist.service.ShoppingListItem;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ShoppingListRepositoryInMemoryImpl implements ShoppingListRepository {

    private Map<Long, ShoppingList> shoppingListStorage;
    private AtomicLong counter = new AtomicLong(0);

    public ShoppingListRepositoryInMemoryImpl() {
        shoppingListStorage = new HashMap<>();
    }

    public ShoppingList save(ShoppingList shoppingList) {
        Long id = shoppingList.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            shoppingList.setId(id);
        }
        shoppingListStorage.put(id, shoppingList);
        return shoppingList;
    }

    public Optional<ShoppingList> findById(Long id) {
        return Optional.ofNullable(shoppingListStorage.get(id));
    }

    public List<ShoppingList> findAll() {
        return new ArrayList<>(shoppingListStorage.values());
    }

    public void deleteById(Long id) {
        shoppingListStorage.remove(id);
    }
}
