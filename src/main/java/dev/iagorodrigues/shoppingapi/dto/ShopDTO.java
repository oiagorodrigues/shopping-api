package dev.iagorodrigues.shoppingapi.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iagorodrigues.shoppingapi.model.Shop;

public class ShopDTO {

    @NotBlank
    private String userIdentifier;

    @NotNull
    private Float total;

    @NotNull
    private Instant date;

    @NotNull
    private List<ShopItemDTO> items;

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public List<ShopItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ShopItemDTO> items) {
        this.items = items;
    }

    public static ShopDTO convert (Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setDate(shop.getDate());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setItems(shop
                .getItems()
                .stream()
                .map(ShopItemDTO::convert)
                .collect(Collectors.toList()));
        return shopDTO;
    }
}
