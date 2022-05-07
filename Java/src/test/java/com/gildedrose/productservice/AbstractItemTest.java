package com.gildedrose.productservice;

import com.gildedrose.model.Item;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractItemTest {

    protected void advanceDay(Item item, int expectedSellIn, int expectedQuality) {
        item.updateQuality();
        assertThat(item.sellIn).isEqualTo(expectedSellIn);
        assertThat(item.quality).isEqualTo(expectedQuality);
    }
}
