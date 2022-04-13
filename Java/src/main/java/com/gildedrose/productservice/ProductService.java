package com.gildedrose.productservice;

import com.gildedrose.Item;

/**
 * Interface for the Strategy Design Pattern. All implementations need to implement this interface.
 */
public interface ProductService extends IsProductType {

    /**
     * Implement the specific way an item must be updated.
     *
     * @param item to update
     */
    void updateItem(Item item);

    /**
     * Since every Product needs to Decrease the SellIn value we can make this a default method.
     */
    default void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

}
