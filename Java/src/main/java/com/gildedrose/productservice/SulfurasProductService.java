package com.gildedrose.productservice;

import com.gildedrose.Item;

public class SulfurasProductService implements ProductService {

    /**
     * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     * No need to check Quality > 50 as the values never change
     * No need to check Quality < 0 as the values never change
     */
    @Override
    public void updateItem(Item item) {
        // do nothing
    }

    @Override
    public ProductType findProductType() {
        return ProductType.SULFURAS;
    }
}
