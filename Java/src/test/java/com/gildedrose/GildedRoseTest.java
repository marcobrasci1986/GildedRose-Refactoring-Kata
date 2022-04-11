package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     */
    @Test
    void qualityDegradesTwiceAsFastWhenSellByDateHasPassed() {
        String NORMAL_PRODUCT = "normal product";
        Item normalProduct = new Item(NORMAL_PRODUCT, 1, 3);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(1);
        assertThat(itemDay0.quality).isEqualTo(3);

        // day 1
        app.updateQuality();
        Item itemDay1 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(0);
        assertThat(itemDay1.quality).isEqualTo(2);

        // day 2
        app.updateQuality();
        Item itemDay2 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(-1);
        assertThat(itemDay2.quality).isEqualTo(0);

        // day 3
        app.updateQuality();
        Item itemDay3 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay3.sellIn).isEqualTo(-2);
        assertThat(itemDay3.quality).isEqualTo(0);

        // day 4
        app.updateQuality();
        Item itemDay4 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay4.sellIn).isEqualTo(-3);
        assertThat(itemDay4.quality).isEqualTo(0);
    }

    /**
     * The Quality of an item is never negative
     */
    @Test
    void qualityIsNeverNegative() {
        String NORMAL_PRODUCT = "normal product";
        Item normalProduct = new Item(NORMAL_PRODUCT, 1, 1);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(1);
        assertThat(itemDay0.quality).isEqualTo(1);

        // day 1
        app.updateQuality();
        Item itemDay1 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(0);
        assertThat(itemDay1.quality).isEqualTo(0);

        // day 2
        app.updateQuality();
        Item itemDay2 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(-1);
        assertThat(itemDay2.quality).isEqualTo(0);

        // day 3
        app.updateQuality();
        Item itemDay3 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay3.sellIn).isEqualTo(-2);
        assertThat(itemDay3.quality).isEqualTo(0);

        // day 4
        app.updateQuality();
        Item itemDay4 = findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay4.sellIn).isEqualTo(-3);
        assertThat(itemDay4.quality).isEqualTo(0);
    }

    @Test
    void qualityIsNeverMoreThen50() {
        Item normalProduct = new Item(GildedRose.PRODUCT_AGED_BRIE, 10, 49);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(49);

        // day 1
        app.updateQuality();
        Item itemDay1 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(9);
        assertThat(itemDay1.quality).isEqualTo(50);

        // day 2
        app.updateQuality();
        Item itemDay2 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(8);
        assertThat(itemDay2.quality).isEqualTo(50);

    }

    /**
     * "Aged Brie" actually increases in Quality the older it gets
     */
    @Test
    void agedBrieIncreasesQualityTheOlderItGets() {
        Item normalProduct = new Item(GildedRose.PRODUCT_AGED_BRIE, 10, 10);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(10);

        // day 1
        app.updateQuality();
        Item itemDay4 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay4.sellIn).isEqualTo(9);
        assertThat(itemDay4.quality).isEqualTo(11);

        // day 2
        app.updateQuality();
        Item itemDay2 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(8);
        assertThat(itemDay2.quality).isEqualTo(12);
    }

    /**
     * The Quality of an item is never more than 50
     */
    @Test
    void qualityOfItemNeverMoreThen50() {
        Item normalProduct = new Item(GildedRose.PRODUCT_AGED_BRIE, 10, 49);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(49);

        // day 1
        app.updateQuality();
        Item itemDay4 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay4.sellIn).isEqualTo(9);
        assertThat(itemDay4.quality).isEqualTo(50);

        // day 2
        app.updateQuality();
        Item itemDay2 = findItem(GildedRose.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(8);
        assertThat(itemDay2.quality).isEqualTo(50);
    }

    /**
     * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     */
    @Test
    void sulfurasIsNeverSoldOrDecreasedInQuality() {
        Item normalProduct = new Item(GildedRose.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 10, 10);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(GildedRose.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(10);

        // day1
        app.updateQuality();
        Item itemDay1 = findItem(GildedRose.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(10);
        assertThat(itemDay1.quality).isEqualTo(10);

        // day2
        app.updateQuality();
        Item itemDay2 = findItem(GildedRose.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(10);
        assertThat(itemDay2.quality).isEqualTo(10);
    }

    @Test
    void backStagePassesQualityIncreasesBy2When10DaysOrLess() {
        Item normalProduct = new Item(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 10, 10);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(10);

        // day1
        app.updateQuality();
        Item itemDay1 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(9);
        assertThat(itemDay1.quality).isEqualTo(12);

        // day2
        app.updateQuality();
        Item itemDay2 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(8);
        assertThat(itemDay2.quality).isEqualTo(14);
    }

    @Test
    void backStagePassesQualityIncreasesBy3When5DaysOrLess() {
        Item normalProduct = new Item(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 5, 10);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(5);
        assertThat(itemDay0.quality).isEqualTo(10);

        // day1
        app.updateQuality();
        Item itemDay1 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(4);
        assertThat(itemDay1.quality).isEqualTo(13);

        // day2
        app.updateQuality();
        Item itemDay2 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(3);
        assertThat(itemDay2.quality).isEqualTo(16);
    }

    @Test
    void backStagePassesQualityDropsTo0WhenConcertIsOver() {
        Item normalProduct = new Item(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 0, 20);
        GildedRose app = new GildedRose(List.of(normalProduct));

        // Initial state
        Item itemDay0 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(0);
        assertThat(itemDay0.quality).isEqualTo(20);

        // day1
        app.updateQuality();
        Item itemDay1 = findItem(GildedRose.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(-1);
        assertThat(itemDay1.quality).isEqualTo(0);
    }

    private Item findItem(String name, List<Item> items) {
        return items.stream()
            .filter(item -> item.name.equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(String.format("Product %s was not found", name)));

    }
}
