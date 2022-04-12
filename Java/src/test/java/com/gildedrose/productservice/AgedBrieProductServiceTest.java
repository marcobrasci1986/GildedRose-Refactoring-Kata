package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieProductServiceTest extends AbstractProductServiceTest {

    private AgedBrieProductService agedBrieProductService;

    @BeforeEach
    void setUp() {
        agedBrieProductService = new AgedBrieProductService();
    }

    @Test
    void qualityIncreaseByDay() {
        Item item = new Item(ProductConstants.PRODUCT_AGED_BRIE, 5, 20);

        advanceDay(agedBrieProductService, item, 4, 21);
        advanceDay(agedBrieProductService, item, 3, 22);
        advanceDay(agedBrieProductService, item, 2, 23);
    }

    @Test
    void qualityCannotExceed50() {
        Item item = new Item(ProductConstants.PRODUCT_AGED_BRIE, 1, 49);

        advanceDay(agedBrieProductService, item, 0, 50);
        advanceDay(agedBrieProductService, item, -1, 50);
        advanceDay(agedBrieProductService, item, -2, 50);
        advanceDay(agedBrieProductService, item, -3, 50);
    }

    @Test
    void qualityIncreaseByDoubleAmountAfterSellInDaysExpired() {
        Item item = new Item(ProductConstants.PRODUCT_AGED_BRIE, 2, 0);

        advanceDay(agedBrieProductService, item, 1, 1);
        advanceDay(agedBrieProductService, item, 0, 2);

        advanceDay(agedBrieProductService, item, -1, 4);
        advanceDay(agedBrieProductService, item, -2, 6);
    }

    @Test
    void findProductType() {
        assertThat(agedBrieProductService.findProductType()).isEqualTo(ProductType.AGED_BRIE);
    }
}
