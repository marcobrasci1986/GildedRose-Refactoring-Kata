package com.gildedrose.productservice.implementations;

import com.gildedrose.Item;
import com.gildedrose.productservice.ProductService;
import com.gildedrose.productservice.ProductType;

public class AgedBrieProductService implements ProductService {

    public static final int DEFAULT_INCREASE_VALUE = 1;

    /**
     * "Aged Brie" actually increases in Quality the older it gets
     * The Quality of an item is never more than 50
     */
    @Override
    public void updateItem(Item item) {
        decreaseSellIn(item);
        increaseQualityByDay(item);
    }


    private void increaseQualityByDay(Item item) {
        if (item.quality < 50) {
            int increaseValue = findIncreaseValue(item);
            item.quality = item.quality + increaseValue;
        }
    }

    private int findIncreaseValue(Item item) {
        if (item.sellIn >= 0) {
            return DEFAULT_INCREASE_VALUE;
        } else {
            return DEFAULT_INCREASE_VALUE * 2;
        }
    }

    @Override
    public ProductType findProductType() {
        return ProductType.AGED_BRIE;
    }
}
