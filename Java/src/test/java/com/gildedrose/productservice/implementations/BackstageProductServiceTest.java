package com.gildedrose.productservice.implementations;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import com.gildedrose.productservice.AbstractProductServiceTest;
import com.gildedrose.productservice.ProductType;
import com.gildedrose.productservice.implementations.BackstageProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackstageProductServiceTest extends AbstractProductServiceTest {

    private BackstageProductService backstageProductService;

    @BeforeEach
    void setUp() {
        backstageProductService = new BackstageProductService();
    }

    @Test
    void dayAfterConcert() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 0, 50);

        advanceDay(backstageProductService, item, -1, 0);
    }

    @Test
    void concertIsLessThen5Days() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 4, 20);

        advanceDay(backstageProductService, item, 3, 23);
        advanceDay(backstageProductService, item, 2, 26);
        advanceDay(backstageProductService, item, 1, 29);
    }

    @Test
    void concertIsLessThen10Days() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 10, 20);

        advanceDay(backstageProductService, item, 9, 22);
        advanceDay(backstageProductService, item, 8, 24);
        advanceDay(backstageProductService, item, 7, 26);

    }

    @Test
    void concertIsMore10DaysAway() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 15, 20);

        advanceDay(backstageProductService, item, 14, 21);
        advanceDay(backstageProductService, item, 13, 22);
        advanceDay(backstageProductService, item, 12, 23);
    }

    @Test
    void qualityCannotGoAbove50() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 2, 49);

        advanceDay(backstageProductService, item, 1, 50);
        advanceDay(backstageProductService, item, 0, 50);
    }

    @Test
    void fullCountDown() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 11, 10);

        // >10 = +1
        advanceDay(backstageProductService, item, 10, 11);

        // between 5 and 10 = +2
        advanceDay(backstageProductService, item, 9, 13);
        advanceDay(backstageProductService, item, 8, 15);
        advanceDay(backstageProductService, item, 7, 17);
        advanceDay(backstageProductService, item, 6, 19);
        advanceDay(backstageProductService, item, 5, 21);

        // between 0 and 5
        advanceDay(backstageProductService, item, 4, 24);
        advanceDay(backstageProductService, item, 3, 27);
        advanceDay(backstageProductService, item, 2, 30);
        advanceDay(backstageProductService, item, 1, 33);
        advanceDay(backstageProductService, item, 0, 36);

        // days after concert
        advanceDay(backstageProductService, item, -1, 0);
        advanceDay(backstageProductService, item, -2, 0);
    }

    @Test
    void findProductType() {
        assertThat(backstageProductService.findProductType()).isEqualTo(ProductType.BACKSTAGE_PASS);
    }
}
