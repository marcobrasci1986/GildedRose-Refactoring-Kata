package com.gildedrose;

import com.gildedrose.productservice.ProductService;
import com.gildedrose.productservice.ProductServiceFactory;
import com.gildedrose.productservice.ProductType;
import com.gildedrose.service.ProductTypeService;

import java.util.List;

/**
 * Refactored implementations of {@link GildedRose}
 */
public class GildedRoseNew {
    private final List<Item> items;

    private final ProductServiceFactory productServiceFactory;
    private final ProductTypeService productTypeService;

    public GildedRoseNew(
        List<Item> items,
        ProductServiceFactory productServiceFactory,
        ProductTypeService productTypeService
    ) {
        this.items = items;
        this.productServiceFactory = productServiceFactory;
        this.productTypeService = productTypeService;
    }

    public void updateQuality() {
        items.forEach(item -> {
            ProductType productType = productTypeService.findProductType(item.name);
            ProductService service = productServiceFactory.findService(productType);
            service.updateItem(item);
        });
    }

    public List<Item> getItems() {
        return items;
    }
}
