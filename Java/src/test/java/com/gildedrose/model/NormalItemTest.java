package com.gildedrose.model;

import com.gildedrose.productservice.AbstractItemTest;
import org.junit.jupiter.api.Test;

class NormalItemTest extends AbstractItemTest {
    @Test
    void normalSituation() {
        Item item = new NormalItem(10, 10);

        advanceDay(item, 9, 9);
        advanceDay(item, 8, 8);
        advanceDay(item, 7, 7);
    }

    @Test
    void qualityDegradesTwiceAsFastPassedSellByDate() {
        Item item = new NormalItem(0, 10);

        advanceDay(item, -1, 8);
        advanceDay(item, -2, 6);
        advanceDay(item, -3, 4);
    }

    @Test
    void qualityCannotBecomeNegative() {
        Item item = new NormalItem(1, 4);

        advanceDay(item, 0, 3);
        advanceDay(item, -1, 1);
        advanceDay(item, -2, 0);
        advanceDay(item, -3, 0);
        advanceDay(item, -4, 0);
    }
}
