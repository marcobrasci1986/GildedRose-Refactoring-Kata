package com.gildedrose.productservice;

import com.gildedrose.Item;

public interface ProductService extends IsProductType {

    void updateItem(Item item);
}
