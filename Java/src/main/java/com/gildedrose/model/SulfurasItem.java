package com.gildedrose.model;

public class SulfurasItem extends Item {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateQuality() {
        // do nothing
    }
}
