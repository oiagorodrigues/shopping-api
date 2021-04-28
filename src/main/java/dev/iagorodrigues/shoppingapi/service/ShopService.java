package dev.iagorodrigues.shoppingapi.service;

import dev.iagorodrigues.shoppingapi.dto.ShopDTO;
import dev.iagorodrigues.shoppingapi.dto.ShopItemDTO;
import dev.iagorodrigues.shoppingapi.model.Shop;
import dev.iagorodrigues.shoppingapi.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopDTO> getAll() {
        return shopRepository.findAll()
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser (String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier)
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate (ShopDTO shopDTO) {
        return shopRepository.findAllByDateGreaterThan(shopDTO.getDate())
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById (long productId) {
        return shopRepository.findById(productId).map(ShopDTO::convert).orElse(null);
    }

    public ShopDTO save (ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO.getShopItemsDTO()
                        .stream()
                        .map(ShopItemDTO::getPrice)
                        .reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date().toInstant());

        shop = shopRepository.save(shop);
        return ShopDTO.convert(shop);
    }

}
