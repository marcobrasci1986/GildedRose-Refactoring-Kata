package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductService;
import com.gildedrose.ProductType;

/**
 * TODO Check Aged Brie + Elixer of Goose (Normal product)
 */
public class NormalProductService implements ProductService {

    public static final int DEFAULT_DECREASE_VALUE = 1;

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Override
    public void updateItem(Item item) {
        updateSellIn(item);
        decreaseQualityBasedOnSellInDays(item);
        qualityCannotBeNegative(item);
    }


    private void decreaseQualityBasedOnSellInDays(Item item) {
        int decreaseValue = findDecreaseValue(item);
        item.quality = item.quality - decreaseValue;
    }

    private int findDecreaseValue(Item item) {
        if (item.sellIn >= 0) {
            return DEFAULT_DECREASE_VALUE;
        } else {
            return DEFAULT_DECREASE_VALUE * 2;
        }
    }

    /**
     * The Quality of an item is never negative
     */
    private void qualityCannotBeNegative(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public ProductType forProductType() {
        return ProductType.NORMAL_PRODUCT;
    }
}
