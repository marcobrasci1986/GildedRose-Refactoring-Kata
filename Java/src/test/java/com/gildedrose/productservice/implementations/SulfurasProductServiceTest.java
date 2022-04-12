package com.gildedrose.productservice.implementations;

import com.gildedrose.Item;
import com.gildedrose.ProductConstants;
import com.gildedrose.productservice.AbstractProductServiceTest;
import com.gildedrose.productservice.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SulfurasProductServiceTest extends AbstractProductServiceTest {

    private SulfurasProductService sulfurasProductService = new SulfurasProductService();

    @BeforeEach
    void setUp() {
        sulfurasProductService = new SulfurasProductService();
    }

    @Test
    void sulfurasIsNeverSoldQualityRemains80() {
        Item item = new Item(ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS, 5, 80);

        advanceDay(sulfurasProductService, item, 5, 80);
        advanceDay(sulfurasProductService, item, 5, 80);
        advanceDay(sulfurasProductService, item, 5, 80);
    }

    @Test
    void findProductType() {
        assertThat(sulfurasProductService.findProductType()).isEqualTo(ProductType.SULFURAS);
    }
}
