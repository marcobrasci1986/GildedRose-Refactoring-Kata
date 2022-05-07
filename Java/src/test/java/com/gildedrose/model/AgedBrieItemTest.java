package com.gildedrose.model;

import com.gildedrose.productservice.AbstractItemTest;
import org.junit.jupiter.api.Test;

class AgedBrieItemTest extends AbstractItemTest {


    @Test
    void qualityIncreaseByDay() {
        Item item = new AgedBrieItem(5, 20);

        advanceDay(item, 4, 21);
        advanceDay(item, 3, 22);
        advanceDay(item, 2, 23);
    }

    @Test
    void qualityCannotExceed50() {
        Item item = new AgedBrieItem(1, 49);

        advanceDay(item, 0, 50);
        advanceDay(item, -1, 50);
        advanceDay(item, -2, 50);
        advanceDay(item, -3, 50);
    }

    @Test
    void qualityCannotExceed50_2() {
        Item item = new AgedBrieItem(1, 48);

        advanceDay(item, 0, 49);
        advanceDay(item, -1, 50);
        advanceDay(item, -2, 50);
        advanceDay(item, -3, 50);
    }

    @Test
    void qualityIncreaseByDoubleAmountAfterSellInDaysExpired() {
        Item item = new AgedBrieItem(2, 0);

        advanceDay(item, 1, 1);
        advanceDay(item, 0, 2);

        advanceDay(item, -1, 4);
        advanceDay(item, -2, 6);
    }
}
