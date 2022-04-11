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
class GildedRose {
    public static final String PRODUCT_AGED_BRIE = "Aged Brie";
    public static final String PRODUCT_BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String PRODUCT_SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals(PRODUCT_AGED_BRIE)
                && !item.name.equals(PRODUCT_BACKSTAGE_PASSES_TO_CONCERT)) {
                if (item.quality > 0) {
                    if (!item.name.equals(PRODUCT_SULFURAS_HAND_OF_RAGNAROS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(PRODUCT_BACKSTAGE_PASSES_TO_CONCERT)) {
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

            if (!item.name.equals(PRODUCT_SULFURAS_HAND_OF_RAGNAROS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(PRODUCT_AGED_BRIE)) {
                    if (!item.name.equals(PRODUCT_BACKSTAGE_PASSES_TO_CONCERT)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(PRODUCT_SULFURAS_HAND_OF_RAGNAROS)) {
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
    }

    public List<Item> getItems() {
        return items;
    }
}
