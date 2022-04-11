package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseNewTest {

    /**
     * Once the sell by date has passed, Quality degrades twice as fast
     * The Quality of an item is never negative
     */
    @Test
    void qualityDegradesTwiceAsFastWhenSellByDateHasPassed() {
        String NORMAL_PRODUCT = "normal product";
        Item normalProduct = new Item(NORMAL_PRODUCT, 1, 3);
        GildedRoseNew app = new GildedRoseNew(List.of(normalProduct));

        // Initial state
        Item itemDay0 = ItemUtil.findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(1);
        assertThat(itemDay0.quality).isEqualTo(3);

        // day 1
        app.updateQuality();
        Item itemDay1 = ItemUtil.findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(0);
        assertThat(itemDay1.quality).isEqualTo(2);

        // day 2
        app.updateQuality();
        Item itemDay2 = ItemUtil.findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(-1);
        assertThat(itemDay2.quality).isEqualTo(0);

        // day 3
        app.updateQuality();
        Item itemDay3 = ItemUtil.findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay3.sellIn).isEqualTo(-2);
        assertThat(itemDay3.quality).isEqualTo(0);

        // day 4
        app.updateQuality();
        Item itemDay4 = ItemUtil.findItem(NORMAL_PRODUCT, app.getItems());
        assertThat(itemDay4.sellIn).isEqualTo(-3);
        assertThat(itemDay4.quality).isEqualTo(0);
    }

    @Test
    void agedBrieIncreaseQualityWhenItGetsOlder() {
        Item normalProduct = new Item(ProductConstants.PRODUCT_AGED_BRIE, 10, 48);
        GildedRoseNew app = new GildedRoseNew(List.of(normalProduct));

        // Initial state
        Item itemDay0 = ItemUtil.findItem(ProductConstants.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(48);

        // day 1
        app.updateQuality();
        Item itemDay1 = ItemUtil.findItem(ProductConstants.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(9);
        assertThat(itemDay1.quality).isEqualTo(49);

        // day 2
        app.updateQuality();
        Item itemDay2 = ItemUtil.findItem(ProductConstants.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(8);
        assertThat(itemDay2.quality).isEqualTo(50);

        // day 3
        app.updateQuality();
        Item itemDay3 = ItemUtil.findItem(ProductConstants.PRODUCT_AGED_BRIE, app.getItems());
        assertThat(itemDay3.sellIn).isEqualTo(7);
        assertThat(itemDay3.quality).isEqualTo(50);
    }

    @Test
    void sulfurasNeverHasToBeSoldOrDecreasedInValue() {
        Item normalProduct = new Item(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 10, 10);
        GildedRoseNew app = new GildedRoseNew(List.of(normalProduct));

        // Initial state
        Item itemDay0 = ItemUtil.findItem(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(10);

        // day 1
        app.updateQuality();
        Item itemDay1 = ItemUtil.findItem(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(10);
        assertThat(itemDay1.quality).isEqualTo(10);

        // day 2
        app.updateQuality();
        Item itemDay2 = ItemUtil.findItem(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(10);
        assertThat(itemDay2.quality).isEqualTo(10);
    }

    @Test
    void backStagePas() {
        Item normalProduct = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 10, 10);
        GildedRoseNew app = new GildedRoseNew(List.of(normalProduct));

        // Initial state
        Item itemDay0 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay0.sellIn).isEqualTo(10);
        assertThat(itemDay0.quality).isEqualTo(10);

        // day 1
        app.updateQuality();
        Item itemDay1 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay1.sellIn).isEqualTo(9);
        assertThat(itemDay1.quality).isEqualTo(12);

        // day 2
        app.updateQuality();
        Item itemDay2 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay2.sellIn).isEqualTo(8);
        assertThat(itemDay2.quality).isEqualTo(14);

        // day 3
        app.updateQuality();
        Item itemDay3 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay3.sellIn).isEqualTo(7);
        assertThat(itemDay3.quality).isEqualTo(16);

        // day 4
        app.updateQuality();
        Item itemDay4 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay4.sellIn).isEqualTo(6);
        assertThat(itemDay4.quality).isEqualTo(18);

        // day 5
        app.updateQuality();
        Item itemDay5 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay5.sellIn).isEqualTo(5);
        assertThat(itemDay5.quality).isEqualTo(21);

        // day 6
        app.updateQuality();
        Item itemDay6 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay6.sellIn).isEqualTo(4);
        assertThat(itemDay6.quality).isEqualTo(24);

        // day 7
        app.updateQuality();
        Item itemDay7 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay7.sellIn).isEqualTo(3);
        assertThat(itemDay7.quality).isEqualTo(27);

        // day 8
        app.updateQuality();
        Item itemDay8 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay8.sellIn).isEqualTo(2);
        assertThat(itemDay8.quality).isEqualTo(30);

        // day 9
        app.updateQuality();
        Item itemDay9 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay9.sellIn).isEqualTo(1);
        assertThat(itemDay9.quality).isEqualTo(33);

        // day 10
        app.updateQuality();
        Item itemDay10 = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(itemDay10.sellIn).isEqualTo(0);
        assertThat(itemDay10.quality).isEqualTo(36);

        // day 10
        app.updateQuality();
        Item dayAfterConcert = ItemUtil.findItem(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, app.getItems());
        assertThat(dayAfterConcert.sellIn).isEqualTo(-1);
        assertThat(dayAfterConcert.quality).isEqualTo(0);

    }
}
