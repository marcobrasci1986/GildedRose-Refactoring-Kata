package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackstageProductServiceTest {

    private BackstageProductService backstageProductService;

    @BeforeEach
    void setUp() {
        backstageProductService = new BackstageProductService();
    }

    @Test
    void dayAfterConcert() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 0, 50);

        backstageProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void concertIsLessThen5Days() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 4, 20);

        backstageProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(3);
        assertThat(item.quality).isEqualTo(23);
    }

    @Test
    void concertIsLessThen10Days() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 10, 20);

        backstageProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(22);
    }

    @Test
    void concertIsLessMore10DaysAway() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 15, 20);

        backstageProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(14);
        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void qualityCannotGoAbove50() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 1, 50);

        backstageProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void fullCountDown() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 11, 10);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(10);
        assertThat(item.quality).isEqualTo(11);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(13);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(8);
        assertThat(item.quality).isEqualTo(15);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(7);
        assertThat(item.quality).isEqualTo(17);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(6);
        assertThat(item.quality).isEqualTo(19);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(5);
        assertThat(item.quality).isEqualTo(21);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(24);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(3);
        assertThat(item.quality).isEqualTo(27);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(2);
        assertThat(item.quality).isEqualTo(30);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(1);
        assertThat(item.quality).isEqualTo(33);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(36);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);

        backstageProductService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(-2);
        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void findProductType() {
        assertThat(backstageProductService.findProductType()).isEqualTo(ProductType.BACKSTAGE_PASS);
    }
}
