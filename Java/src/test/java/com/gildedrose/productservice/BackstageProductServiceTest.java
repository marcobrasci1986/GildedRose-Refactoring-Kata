package com.gildedrose.productservice;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import com.gildedrose.ProductType;
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
    void qualityCannotGoAbove50() {
        Item item = new Item(ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT, 1, 50);

        backstageProductService.updateItem(item);

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void findProductType() {
        assertThat(backstageProductService.forProductType()).isEqualTo(ProductType.BACKSTAGE_PASS);
    }
}
