package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductService;
import com.gildedrose.ProductType;

public class SulfurasProductService implements ProductService {

    /**
     * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     * No need to check Quality > 50 as the values never change
     */
    @Override
    public void updateItem(Item item) {
        // do nothing
    }

    @Override
    public ProductType forProductType() {
        return ProductType.SULFURAS;
    }
}
