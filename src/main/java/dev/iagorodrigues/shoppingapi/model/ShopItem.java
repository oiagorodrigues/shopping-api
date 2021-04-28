package dev.iagorodrigues.shoppingapi.model;

import javax.persistence.Embeddable;

import dev.iagorodrigues.shoppingapi.dto.ShopItemDTO;

@Embeddable
public class ShopItem {

    private String productIdentifier;

    private Float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static ShopItem convert (ShopItemDTO shopItemDTO) {
        ShopItem shopItem = new ShopItem();
        shopItem.setProductIdentifier(shopItemDTO.getProductIdentifier());
        shopItem.setPrice(shopItemDTO.getPrice());
        return shopItem;
    }
}
