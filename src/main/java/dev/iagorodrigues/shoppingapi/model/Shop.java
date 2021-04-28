package dev.iagorodrigues.shoppingapi.model;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import dev.iagorodrigues.shoppingapi.dto.ShopDTO;

@Entity(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userIdentifier;

    private Float total;

    private Instant date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "shop_item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<ShopItem> shopItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public static Shop convert (ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setDate(shopDTO.getDate());
        shop.setTotal(shopDTO.getTotal());
        shop.setShopItems(shopDTO
            .getShopItemsDTO()
            .stream()
            .map(ShopItem::convert)
            .collect(Collectors.toList()));
        return shop;
    }

}
