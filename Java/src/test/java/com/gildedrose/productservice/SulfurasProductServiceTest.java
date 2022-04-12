package com.gildedrose.productservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SulfurasProductServiceTest {

    private SulfurasProductService sulfurasProductService = new SulfurasProductService();

    @BeforeEach
    void setUp() {
        sulfurasProductService = new SulfurasProductService();
    }

    @Test
    void findProductType() {
        assertThat(sulfurasProductService.findProductType()).isEqualTo(ProductType.SULFURAS);
    }
}
