package com.gildedrose.model;

import com.gildedrose.productservice.AbstractItemTest;
import org.junit.jupiter.api.Test;

class ConjuredItemTest extends AbstractItemTest {

    @Test
    void normalSituation() {
        Item item = new ConjuredItem(5, 20);

        advanceDay(item, 4, 18);
        advanceDay(item, 3, 16);
        advanceDay(item, 2, 14);
    }

    @Test
    void pastSellInDate() {
        Item item = new ConjuredItem(1, 20);

        advanceDay(item, 0, 18);
        advanceDay(item, -1, 14);
        advanceDay(item, -2, 10);
    }

    @Test
    void qualityCanNeverBeNegative() {
        Item item = new ConjuredItem(1, 5);

        advanceDay(item, 0, 3);
        advanceDay(item, -1, 0);
        advanceDay(item, -2, 0);
    }
}
