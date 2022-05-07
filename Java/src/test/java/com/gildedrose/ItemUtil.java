package com.gildedrose;

import com.gildedrose.model.Item;

import java.util.List;

public class ItemUtil {

    public ItemUtil() {
        // util
    }

    public static Item findItem(String name, List<Item> items) {
        return items.stream()
            .filter(item -> item.name.equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(String.format("Product %s was not found", name)));
    }
}
