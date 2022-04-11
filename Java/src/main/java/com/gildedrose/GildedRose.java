package com.gildedrose;

import java.util.List;

/*
SellIn value which denotes the number of days we have to sell the item
Quality value which denotes how valuable the item is
At the end of each day our system lowers both values for every item

Gameplan

Write tests for existing code.
Refactoring into smaller methods
Tackle "Conjured Mana Cake"

 */
@Deprecated
public class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals(ProductConstants.PRODUCT_AGED_BRIE)
                && !item.name.equals(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT)) {
                if (item.quality > 0) {
                    if (!item.name.equals(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            decreaseSellInDate(item);
            handleSellDatePassed(item);
        }
    }


    private void decreaseSellInDate(Item item) {
        if (!item.name.equals(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void handleSellDatePassed(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals(ProductConstants.PRODUCT_AGED_BRIE)) {
                if (!item.name.equals(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
