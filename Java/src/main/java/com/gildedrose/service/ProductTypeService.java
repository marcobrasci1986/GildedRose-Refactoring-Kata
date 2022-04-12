package com.gildedrose.service;

import com.gildedrose.ProductConstants;
import com.gildedrose.productservice.ProductType;

public class ProductTypeService {

    public ProductType findProductType(String name) {
        switch (name) {
            case ProductConstants.PRODUCT_AGED_BRIE:
                return ProductType.AGED_BRIE;
            case ProductConstants.PRODUCT_BACKSTAGE_PASSES_TO_CONCERT:
                return ProductType.BACKSTAGE_PASS;
            case ProductConstants.PRODUCT_SULFURAS_HAND_OF_RAGNAROS:
                return ProductType.SULFURAS;
            case ProductConstants.PRODUCT_CONJURED_MANA_CAKE:
                return ProductType.CONJURED;
            default:
                return ProductType.NORMAL_PRODUCT;
        }

    }
}
