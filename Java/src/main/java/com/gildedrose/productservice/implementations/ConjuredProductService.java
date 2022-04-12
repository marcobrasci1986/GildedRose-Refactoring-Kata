package com.gildedrose.productservice.implementations;

import com.gildedrose.EnsureQualityIsNotNegative;
import com.gildedrose.Item;
import com.gildedrose.productservice.ProductService;
import com.gildedrose.productservice.ProductType;

public class ConjuredProductService implements ProductService, EnsureQualityIsNotNegative {

    /**
     * Quality twice as fast as normal items
     */
    public static final int DEFAULT_DECREASE_VALUE = (NormalProductService.DEFAULT_DECREASE_VALUE * 2);

    /**
     * Quality twice as fast as normal items (sellInDate >= 0  = -2, sellInDate < 0  = -4)
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

    @Override
    public ProductType findProductType() {
        return ProductType.CONJURED;
    }
}
