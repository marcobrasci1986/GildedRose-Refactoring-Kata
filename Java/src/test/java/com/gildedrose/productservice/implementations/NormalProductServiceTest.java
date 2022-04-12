package com.gildedrose.productservice.implementations;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import com.gildedrose.productservice.AbstractProductServiceTest;
import com.gildedrose.productservice.ProductType;
import com.gildedrose.productservice.implementations.NormalProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalProductServiceTest extends AbstractProductServiceTest {

    private NormalProductService normalProductService;

    @BeforeEach
    void setUp() {
        normalProductService = new NormalProductService();
    }

    @Test
    void normalSituation() {
        Item item = new Item(ProductConstants.PRODUCT_NORMAL, 10, 10);

        advanceDay(normalProductService, item, 9, 9);
        advanceDay(normalProductService, item, 8, 8);
        advanceDay(normalProductService, item, 7, 7);
    }

    @Test
    void qualityDegradesTwiceAsFastPassedSellByDate() {
        Item item = new Item(ProductConstants.PRODUCT_NORMAL, 0, 10);

        advanceDay(normalProductService, item, -1, 8);
        advanceDay(normalProductService, item, -2, 6);
        advanceDay(normalProductService, item, -3, 4);
    }

    @Test
    void qualityCannotBecomeNegative() {
        Item item = new Item(ProductConstants.PRODUCT_NORMAL, 1, 4);

        advanceDay(normalProductService, item, 0, 3);
        advanceDay(normalProductService, item, -1, 1);
        advanceDay(normalProductService, item, -2, 0);
        advanceDay(normalProductService, item, -3, 0);
        advanceDay(normalProductService, item, -4, 0);
    }

    @Test
    void productType() {
        assertThat(normalProductService.findProductType()).isEqualTo(ProductType.NORMAL_PRODUCT);
    }
}
