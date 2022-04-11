package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductService;
import com.gildedrose.ProductType;

public class NormalProductService implements ProductService {

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Override
    public void updateItem(Item item) {
        decreaseQualityBasedOnSellInDays(item);
        updateSellIn(item);
        qualityCannotBeNegative(item);
    }


    private void decreaseQualityBasedOnSellInDays(Item item) {
        if (item.sellIn >= 0) {
            item.quality = item.quality - 1;
        } else {
            item.quality = item.quality - 2;
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
