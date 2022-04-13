package com.gildedrose.productservice;

import com.gildedrose.productservice.implementations.*;

import java.util.EnumMap;
import java.util.Map;

/**
 * Factory to find the specific implementation based on the productType
 */
public class ServiceFactory {

    private final Map<ProductType, ProductService> serviceMap;

    /**
     * With Spring we would use DI to inject all implementations of ProductService in a List.
     * We can then loop over the implementation and add it to the map
     */
    public ServiceFactory() {
        serviceMap = new EnumMap<>(ProductType.class);
        this.serviceMap.put(ProductType.NORMAL_PRODUCT, new NormalProductService());
        this.serviceMap.put(ProductType.AGED_BRIE, new AgedBrieProductService());
        this.serviceMap.put(ProductType.SULFURAS, new SulfurasProductService());
        this.serviceMap.put(ProductType.BACKSTAGE_PASS, new BackstageProductService());
        this.serviceMap.put(ProductType.CONJURED, new ConjuredProductService());
    }

    public ProductService findService(ProductType productType) {
        return serviceMap.get(productType);
    }
}
