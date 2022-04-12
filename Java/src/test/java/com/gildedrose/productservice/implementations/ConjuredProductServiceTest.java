package com.gildedrose.productservice.implementations;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import com.gildedrose.productservice.AbstractProductServiceTest;
import com.gildedrose.productservice.ProductType;
import com.gildedrose.productservice.implementations.ConjuredProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredProductServiceTest extends AbstractProductServiceTest {

    private ConjuredProductService conjuredProductService;

    @BeforeEach
    void setUp() {
        conjuredProductService = new ConjuredProductService();
    }

    @Test
    void normalSituation() {
        Item item = new Item(ProductConstants.PRODUCT_CONJURED_MANA_CAKE, 5, 20);

        advanceDay(conjuredProductService, item, 4, 18);
        advanceDay(conjuredProductService, item, 3, 16);
        advanceDay(conjuredProductService, item, 2, 14);
    }

    @Test
    void pastSellInDate() {
        Item item = new Item(ProductConstants.PRODUCT_CONJURED_MANA_CAKE, 1, 20);

        advanceDay(conjuredProductService, item, 0, 18);
        advanceDay(conjuredProductService, item, -1, 14);
        advanceDay(conjuredProductService, item, -2, 10);
    }

    @Test
    void qualityCanNeverBeNegative() {
        Item item = new Item(ProductConstants.PRODUCT_CONJURED_MANA_CAKE, 1, 5);

        advanceDay(conjuredProductService, item, 0, 3);
        advanceDay(conjuredProductService, item, -1, 0);
        advanceDay(conjuredProductService, item, -2, 0);
    }

    @Test
    void findProductType() {
        assertThat(conjuredProductService.findProductType()).isEqualTo(ProductType.CONJURED);
    }
}
