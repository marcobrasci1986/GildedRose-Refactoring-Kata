package com.gildedrose.model;

import com.gildedrose.productservice.AbstractItemTest;
import org.junit.jupiter.api.Test;

class SulfurasItemTest extends AbstractItemTest {

    @Test
    void sulfurasIsNeverSoldQualityRemains80() {
        Item item = new SulfurasItem(5, 80);

        advanceDay(item, 5, 80);
        advanceDay(item, 5, 80);
        advanceDay(item, 5, 80);
    }
}
