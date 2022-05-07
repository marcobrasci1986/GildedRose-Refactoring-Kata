package com.gildedrose.model;

public class ConjuredItem extends Item {
    public static final String NAME = "Conjured Mana Cake";
    public static final int DEFAULT_DECREASE_VALUE = (NormalItem.DEFAULT_DECREASE_VALUE * 2);

    public ConjuredItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();
        decreaseQualityBasedOnSellInDays();
        ensureQualityIsNeverNegative();
    }

    private void decreaseQualityBasedOnSellInDays() {
        int decreaseValue = findDecreaseValue(this);
        this.quality = this.quality - decreaseValue;
    }

    private int findDecreaseValue(Item item) {
        if (item.sellIn >= 0) {
            return DEFAULT_DECREASE_VALUE;
        } else {
            return DEFAULT_DECREASE_VALUE * 2;
        }
    }
}
