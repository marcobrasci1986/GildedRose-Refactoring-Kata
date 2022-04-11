package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductService;
import com.gildedrose.ProductType;

public class BackstageProductService implements ProductService {

    /**
     * "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * Quality drops to 0 after the concert
     *
     * @param item
     */
    @Override
    public void updateItem(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = item.quality + 3;
        } else if (item.sellIn <= 10) {
            item.quality = item.quality + 2;
        } else {
            item.quality = item.quality + 1;
        }

        updateSellIn(item);

        ensureQualityNeverExceeds50(item);
    }

    private void ensureQualityNeverExceeds50(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public ProductType forProductType() {
        return ProductType.BACKSTAGE_PASS;
    }
}
