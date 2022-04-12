package com.gildedrose.productservice;

import com.gildedrose.Item;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractProductServiceTest {

    protected void advanceDay(ProductService productService, Item item, int expectedSellIn, int expectedQuality) {
        productService.updateItem(item);
        assertThat(item.sellIn).isEqualTo(expectedSellIn);
        assertThat(item.quality).isEqualTo(expectedQuality);
    }
}
