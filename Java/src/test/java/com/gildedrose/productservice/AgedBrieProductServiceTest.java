package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import com.gildedrose.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieProductServiceTest {

    private AgedBrieProductService agedBrieProductService;

    @BeforeEach
    void setUp() {
        agedBrieProductService = new AgedBrieProductService();
    }

    @Test
    void qualityIncreaseByDay() {
        Item item = new Item(ProductConstants.PRODUCT_AGED_BRIE, 1, 20);

        agedBrieProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void qualityCannotExceed50() {
        Item item = new Item(ProductConstants.PRODUCT_AGED_BRIE, 1, 50);

        agedBrieProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void findProductType() {
        assertThat(agedBrieProductService.forProductType()).isEqualTo(ProductType.AGED_BRIE);
    }
}
