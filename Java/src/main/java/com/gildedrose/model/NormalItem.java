package com.gildedrose.model;

public class NormalItem extends Item {
    public static final String NAME = "Normal Product";
    public static final int DEFAULT_DECREASE_VALUE = 1;

    public NormalItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        decreaseQualityBasedOnSellInDays();
        ensureQualityIsNeverNegative();
    }

    private void decreaseQualityBasedOnSellInDays() {
        int decreaseValue = findDecreaseValue();
        this.quality = this.quality - decreaseValue;
    }

    private int findDecreaseValue() {
        if (this.sellIn >= 0) {
            return DEFAULT_DECREASE_VALUE;
        } else {
            return DEFAULT_DECREASE_VALUE * 2;
        }
    }


}
