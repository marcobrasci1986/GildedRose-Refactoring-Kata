package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductService;
import com.gildedrose.ProductType;

public class AgedBrieProductService implements ProductService {

    /**
     * "Aged Brie" actually increases in Quality the older it gets
     */
    @Override
    public void updateItem(Item item) {
        increaseQualityByDay(item);
        updateSellIn(item);
    }


    private void increaseQualityByDay(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }


    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public ProductType forProductType() {
        return ProductType.AGED_BRIE;
    }
}
