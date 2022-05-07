package com.gildedrose.model;

public class AgedBrieItem extends Item {

    public static final String NAME = "Aged Brie";
    public static final int DEFAULT_INCREASE_VALUE = 1;

    public AgedBrieItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        increaseQualityByDay();

        ensureQualityNeverExceeds50();
    }

    private void increaseQualityByDay() {
        if (this.quality < 50) {
            int increaseValue = findIncreaseValue();
            this.quality = this.quality + increaseValue;
        }
    }

    private int findIncreaseValue() {
        if (this.sellIn >= 0) {
            return DEFAULT_INCREASE_VALUE;
        } else {
            return DEFAULT_INCREASE_VALUE * 2;
        }
    }
}
