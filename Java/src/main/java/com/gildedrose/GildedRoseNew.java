package com.gildedrose;

import com.gildedrose.productservice.ServiceFactory;

import java.util.List;


class GildedRoseNew {
    public static final String PRODUCT_AGED_BRIE = "Aged Brie";
    public static final String PRODUCT_BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String PRODUCT_SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    List<Item> items;

    private final ServiceFactory serviceFactory;

    public GildedRoseNew(List<Item> items) {
        this.items = items;
        this.serviceFactory = new ServiceFactory();
    }

    public void updateQuality() {
        for (Item item : items) {
            ProductType productType = findProductType(item.name);
            ProductService service = serviceFactory.findService(productType);

            service.updateItem(item);

        }
    }

    private ProductType findProductType(String name) {

        switch (name) {
            case PRODUCT_AGED_BRIE:
                return ProductType.AGED_BRIE;
            case PRODUCT_BACKSTAGE_PASSES_TO_CONCERT:
                return ProductType.BACKSTAGE_PASS;
            case PRODUCT_SULFURAS_HAND_OF_RAGNAROS:
                return ProductType.SULFURAS;
            default:
                return ProductType.NORMAL_PRODUCT;
        }

    }


    public List<Item> getItems() {
        return items;
    }
}
