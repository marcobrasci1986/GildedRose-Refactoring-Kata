package com.gildedrose.productservice.implementations;

import com.gildedrose.Item;
import com.gildedrose.productservice.ProductService;
import com.gildedrose.productservice.ProductType;

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
//        System.out.println("---------------------");
//        System.out.println("SellIn before any update: " + item.sellIn);
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            // Concert is over. Tickets have no value anymore
            item.quality = 0;
//            System.out.println("Concert is over: Quality is 0");
        } else {
            int increaseValue = findIncreaseValue(item);
            item.quality = item.quality + increaseValue;
//            System.out.println("Quality inceased by: " + increaseValue);
        }


        ensureQualityNeverExceeds50(item);
    }

    /**
     * How do I decrease Cyclomatic complexity here?
     * <p>
     * We use < 5 (and not <= 5) because the sellInValue is already been decreased in value at this point
     * We use < 10 (and not <= 10) because the sellInValue is already been decreased in value at this point
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

    @Override
    public ProductType findProductType() {
        return ProductType.BACKSTAGE_PASS;
    }
}
