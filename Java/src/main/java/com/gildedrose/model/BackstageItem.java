package com.gildedrose.model;

public class BackstageItem extends Item {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstageItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        decreaseQuality();
        ensureQualityNeverExceeds50();
    }

    private void decreaseQuality() {
        if (this.sellIn < 0) {
            // Concert is over. Tickets have no value anymore
            this.quality = 0;
        } else {
            int increaseValue = findIncreaseValue();
            this.quality = this.quality + increaseValue;
        }
    }

    private int findIncreaseValue() {
        if (this.sellIn < 5) {
            return 3;
        } else if (this.sellIn < 10) {
            return 2;
        } else {
            return 1;
        }
    }
}
