package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalProductServiceTest {

    private NormalProductService normalProductService;

    @BeforeEach
    void setUp() {
        normalProductService = new NormalProductService();
    }

    @Test
    void normalSituation() {
        Item item = new Item(ProductConstants.PRODUCT_NORMAL, 10, 10);

        normalProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(9);
    }

    @Test
    void decreaseBy1OnLastDay() {
        Item item = new Item(ProductConstants.PRODUCT_NORMAL, 0, 10);

        normalProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void decreaseBy2AfterSellDateHasPassed() {
        Item item = new Item(ProductConstants.PRODUCT_NORMAL, 2, 10);

        normalProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(1);
        assertThat(item.quality).isEqualTo(9);

        normalProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(8);

        normalProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(6);

        normalProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(-2);
        assertThat(item.quality).isEqualTo(4);
    }
}
