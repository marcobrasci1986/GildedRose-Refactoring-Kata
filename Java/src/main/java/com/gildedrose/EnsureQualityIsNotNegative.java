package com.gildedrose;

/**
 * Not every Product needs this functionality. With this interface we can pick and choose for whoever needs it.
 */
public interface EnsureQualityIsNotNegative {

    default void ensureQualityIsNeverNegative(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
