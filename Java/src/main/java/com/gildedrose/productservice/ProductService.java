package com.gildedrose.productservice;

import com.gildedrose.Item;

public interface ProductService extends IsProductType {

    void updateItem(Item item);

    /**
     * Since every Product needs to Decrease the SellIn value we can make this a default method.
     */
    default void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

}
