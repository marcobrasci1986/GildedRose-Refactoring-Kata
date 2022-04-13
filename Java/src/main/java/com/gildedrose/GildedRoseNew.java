package com.gildedrose;

import com.gildedrose.productservice.ProductService;
import com.gildedrose.productservice.ProductType;
import com.gildedrose.productservice.ServiceFactory;
import com.gildedrose.service.ProductTypeService;

import java.util.List;

public class GildedRoseNew {
    private final List<Item> items;

    private final ServiceFactory serviceFactory;
    private final ProductTypeService productTypeService;

    public GildedRoseNew(
        List<Item> items,
        ServiceFactory serviceFactory,
        ProductTypeService productTypeService
    ) {
        this.items = items;
        this.serviceFactory = serviceFactory;
        this.productTypeService = productTypeService;
    }

    public void updateQuality() {
        items.forEach(item -> {
            ProductType productType = productTypeService.findProductType(item.name);
            ProductService service = serviceFactory.findService(productType);
            service.updateItem(item);
        });
    }

    public List<Item> getItems() {
        return items;
    }
}
