package dev.iagorodrigues.shoppingapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iagorodrigues.shoppingapi.model.ShopItem;

public class ShopItemDTO {

    @NotBlank
    private String productIdentifier;

    @NotNull
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

    public static ShopItemDTO convert (ShopItem shopItem) {
        ShopItemDTO shopItemDTO = new ShopItemDTO();
        shopItemDTO.setProductIdentifier(shopItem.getProductIdentifier());
        shopItemDTO.setPrice(shopItem.getPrice());
        return shopItemDTO;
    }

}
