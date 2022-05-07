package com.gildedrose;

import com.gildedrose.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseNewIntegrationTest {

    @Test
    void normalProductCountdown() {
        final String NORMAL_PRODUCT = "normal product";
        Item normalProduct = new NormalItem(NORMAL_PRODUCT, 2, 20);
        GildedRoseNew app = new GildedRoseNew(List.of(normalProduct));

        // Initial state
        checkState(app, NORMAL_PRODUCT, 2, 20);

        // days countdown
        advanceDay(app, NORMAL_PRODUCT, 1, 19);
        advanceDay(app, NORMAL_PRODUCT, 0, 18);
        advanceDay(app, NORMAL_PRODUCT, -1, 16);

    }

    @Test
    void sulfurasProductCountdown() {
        Item sulfuras = new SulfurasItem(2, 80);
        GildedRoseNew app = new GildedRoseNew(List.of(sulfuras));

        // Initial state
        checkState(app, SulfurasItem.NAME, 2, 80);

        // days countdown
        advanceDay(app, SulfurasItem.NAME, 2, 80);
        advanceDay(app, SulfurasItem.NAME, 2, 80);
        advanceDay(app, SulfurasItem.NAME, 2, 80);
    }

    @Test
    void agedBrie() {
        Item agedBrie = new AgedBrieItem(2, 0);
        GildedRoseNew app = new GildedRoseNew(List.of(agedBrie));

        // Initial state
        checkState(app, AgedBrieItem.NAME, 2, 0);

        // days countdown
        advanceDay(app, AgedBrieItem.NAME, 1, 1);
        advanceDay(app, AgedBrieItem.NAME, 0, 2);
        advanceDay(app, AgedBrieItem.NAME, -1, 4);
        advanceDay(app, AgedBrieItem.NAME, -2, 6);
    }

    @Test
    void backStagePasses() {
        Item backstageItem = new BackstageItem(15, 20);
        GildedRoseNew app = new GildedRoseNew(List.of(backstageItem));

        // Initial state
        checkState(app, BackstageItem.NAME, 15, 20);

        // days countdown
        advanceDay(app, BackstageItem.NAME, 14, 21);
        advanceDay(app, BackstageItem.NAME, 13, 22);
        advanceDay(app, BackstageItem.NAME, 12, 23);
        advanceDay(app, BackstageItem.NAME, 11, 24);
        advanceDay(app, BackstageItem.NAME, 10, 25);

        advanceDay(app, BackstageItem.NAME, 9, 27);
        advanceDay(app, BackstageItem.NAME, 8, 29);
        advanceDay(app, BackstageItem.NAME, 7, 31);
        advanceDay(app, BackstageItem.NAME, 6, 33);
        advanceDay(app, BackstageItem.NAME, 5, 35);

        advanceDay(app, BackstageItem.NAME, 4, 38);
        advanceDay(app, BackstageItem.NAME, 3, 41);
        advanceDay(app, BackstageItem.NAME, 2, 44);
        advanceDay(app, BackstageItem.NAME, 1, 47);
        advanceDay(app, BackstageItem.NAME, 0, 50);

        advanceDay(app, BackstageItem.NAME, -1, 0);
    }

    @Test
    void conjuredItem() {
        Item conjuredManaCake = new ConjuredItem(2, 10);
        GildedRoseNew app = new GildedRoseNew(List.of(conjuredManaCake));

        // Initial state
        checkState(app, ConjuredItem.NAME, 2, 10);

        // days countdown
        advanceDay(app, ConjuredItem.NAME, 1, 8);
        advanceDay(app, ConjuredItem.NAME, 0, 6);
        advanceDay(app, ConjuredItem.NAME, -1, 2);
        advanceDay(app, ConjuredItem.NAME, -2, 0);
    }

    private void checkState(GildedRoseNew app, String name, int expectedSellIn, int expectedQuality) {
        Item item = ItemUtil.findItem(name, app.getItems());
        assertThat(item.sellIn).isEqualTo(expectedSellIn);
        assertThat(item.quality).isEqualTo(expectedQuality);
    }

    private void advanceDay(GildedRoseNew app, String name, int expectedSellIn, int expectedQuality) {
        app.updateQuality();
        checkState(app, name, expectedSellIn, expectedQuality);
    }
}
