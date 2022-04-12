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
        updateSellIn(item);

        if (item.sellIn < 0) {
            // Concert is over. Tickets have no value anymore
            item.quality = 0;
        } else {
            int increaseValue = findIncreaseValue(item);
            item.quality = item.quality + increaseValue;
        }

        ensureQualityNeverExceeds50(item);
    }

    /**
     * How do I decrease Cyclomatic complexity here?
     */
    private int findIncreaseValue(Item item) {
        if (item.sellIn < 5) {
            return 3;
        } else if (item.sellIn < 10) {
            return 2;
        } else {
            return 1;
        }
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
