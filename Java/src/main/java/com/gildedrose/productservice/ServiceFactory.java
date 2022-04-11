package com.gildedrose.productservice;

import com.gildedrose.ProductService;
import com.gildedrose.ProductType;

import java.util.EnumMap;
import java.util.Map;

public class ServiceFactory {

    private final Map<ProductType, ProductService> serviceMap;

    public ServiceFactory() {
        serviceMap = new EnumMap<>(ProductType.class);
        this.serviceMap.put(ProductType.NORMAL_PRODUCT, new NormalProductService());
        this.serviceMap.put(ProductType.AGED_BRIE, new AgedBrieProductService());
        this.serviceMap.put(ProductType.SULFURAS, new SulfurasProductService());
        this.serviceMap.put(ProductType.BACKSTAGE_PASS, new BackstageProductService());
    }

    public ProductService findService(ProductType productType) {
        return serviceMap.get(productType);
    }
}
