package com.gildedrose;

import com.gildedrose.model.Item;

import java.util.List;

/**
 * Refactored implementations of {@link GildedRose}
 */
public class GildedRoseNew {
    private final List<Item> items;


    public GildedRoseNew(
        List<Item> items
    ) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(Item::updateQuality);
    }

    public List<Item> getItems() {
        return items;
    }
}
