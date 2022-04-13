package com.gildedrose.productservice;

/**
 * Every implementation of the Strategy Pattern needs to implement this interface. It provides the key of the implementations map.
 */
public interface IsProductType {

    ProductType findProductType();
}
