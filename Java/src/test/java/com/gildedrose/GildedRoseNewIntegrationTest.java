package com.gildedrose;

import com.gildedrose.productservice.ServiceFactory;
import com.gildedrose.service.ProductTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseNewIntegrationTest {

    private ServiceFactory serviceFactory;
    private ProductTypeService productTypeService;

    @BeforeEach
    void setUp() {
        serviceFactory = new ServiceFactory();
        productTypeService = new ProductTypeService();
    }

    @Test
    void normalProductCountdown() {
        final String NORMAL_PRODUCT = "normal product";
        Item normalProduct = new Item(NORMAL_PRODUCT, 2, 20);
        GildedRoseNew app = new GildedRoseNew(List.of(normalProduct), serviceFactory, productTypeService);

        // Initial state
        checkState(app, NORMAL_PRODUCT, 2, 20);

        // days countdown
        advanceDay(app, NORMAL_PRODUCT, 1, 19);
        advanceDay(app, NORMAL_PRODUCT, 0, 18);
        advanceDay(app, NORMAL_PRODUCT, -1, 16);

    }

    @Test
    void sulfurasProductCountdown() {
        Item sulfuras = new Item(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 2, 80);
        GildedRoseNew app = new GildedRoseNew(List.of(sulfuras), serviceFactory, productTypeService);

        // Initial state
        checkState(app, ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 2, 80);

        // days countdown
        advanceDay(app, ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 2, 80);
        advanceDay(app, ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 2, 80);
        advanceDay(app, ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 2, 80);
    }

    @Test
    void agedBrie() {
        Item agedBrie = new Item(ProductConstants.PRODUCT_AGED_BRIE, 2, 0);
        GildedRoseNew app = new GildedRoseNew(List.of(agedBrie), serviceFactory, productTypeService);

        // Initial state
        checkState(app, ProductConstants.PRODUCT_AGED_BRIE, 2, 0);

        // days countdown
        advanceDay(app, ProductConstants.PRODUCT_AGED_BRIE, 1, 1);
        advanceDay(app, ProductConstants.PRODUCT_AGED_BRIE, 0, 2);
        advanceDay(app, ProductConstants.PRODUCT_AGED_BRIE, -1, 4);
        advanceDay(app, ProductConstants.PRODUCT_AGED_BRIE, -2, 6);
    }

    @Test
    void backStagePasses() {
        Item agedBrie = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 15, 20);
        GildedRoseNew app = new GildedRoseNew(List.of(agedBrie), serviceFactory, productTypeService);

        // Initial state
        checkState(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 15, 20);

        // days countdown
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 14, 21);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 13, 22);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 12, 23);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 11, 24);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 10, 25);

        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 9, 27);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 8, 29);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 7, 31);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 6, 33);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 5, 35);

        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 4, 38);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 3, 41);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 2, 44);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 1, 47);
        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 0, 50);

        advanceDay(app, ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, -1, 0);
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
