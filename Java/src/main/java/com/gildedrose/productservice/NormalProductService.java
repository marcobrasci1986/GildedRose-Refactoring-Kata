package com.gildedrose.productservice;

import com.gildedrose.Item;

public class NormalProductService implements ProductService {

    public static final int DEFAULT_DECREASE_VALUE = 1;

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     * No need to check Quality > 50 as the values can only go down
     * Quality cannot be negative
     */
    @Override
    public void updateItem(Item item) {
        updateSellIn(item);
        decreaseQualityBasedOnSellInDays(item);
        ensureQualityIsNeverNegative(item);
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

    private void ensureQualityIsNeverNegative(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public ProductType findProductType() {
        return ProductType.NORMAL_PRODUCT;
    }
}
