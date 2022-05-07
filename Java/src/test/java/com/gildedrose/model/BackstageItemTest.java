package com.gildedrose.model;

import com.gildedrose.productservice.AbstractItemTest;
import org.junit.jupiter.api.Test;

class BackstageItemTest extends AbstractItemTest {

    @Test
    void dayAfterConcert() {
        Item item = new BackstageItem(0, 50);

        advanceDay(item, -1, 0);
    }

    @Test
    void concertIsLessThen5Days() {
        Item item = new BackstageItem(4, 20);

        advanceDay(item, 3, 23);
        advanceDay(item, 2, 26);
        advanceDay(item, 1, 29);
    }

    @Test
    void concertIsLessThen10Days() {
        Item item = new BackstageItem(10, 20);

        advanceDay(item, 9, 22);
        advanceDay(item, 8, 24);
        advanceDay(item, 7, 26);

    }

    @Test
    void concertIsMore10DaysAway() {
        Item item = new BackstageItem(15, 20);

        advanceDay(item, 14, 21);
        advanceDay(item, 13, 22);
        advanceDay(item, 12, 23);
    }

    @Test
    void qualityCannotGoAbove50() {
        Item item = new BackstageItem(2, 49);

        advanceDay(item, 1, 50);
        advanceDay(item, 0, 50);
    }

    @Test
    void fullCountDown() {
        Item item = new BackstageItem(11, 10);

        // >10 = +1
        advanceDay(item, 10, 11);

        // between 5 and 10 = +2
        advanceDay(item, 9, 13);
        advanceDay(item, 8, 15);
        advanceDay(item, 7, 17);
        advanceDay(item, 6, 19);
        advanceDay(item, 5, 21);

        // between 0 and 5
        advanceDay(item, 4, 24);
        advanceDay(item, 3, 27);
        advanceDay(item, 2, 30);
        advanceDay(item, 1, 33);
        advanceDay(item, 0, 36);

        // days after concert
        advanceDay(item, -1, 0);
        advanceDay(item, -2, 0);
    }
}
