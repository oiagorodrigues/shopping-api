package dev.iagorodrigues.shoppingapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import dev.iagorodrigues.shoppingapi.dto.ShopDTO;
import dev.iagorodrigues.shoppingapi.service.ShopService;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/shopping")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<ShopDTO> getShops() {
        return shopService.getAll();
    }

    @GetMapping("/{id}")
    public ShopDTO findById (@PathVariable Long id) {
        return shopService.findById(id);
    }

    @GetMapping("/user/{userIdentifier}")
    public List<ShopDTO> getShops (@PathVariable String userIdentifier) {
        return shopService.getByUser(userIdentifier);
    }

    @GetMapping("/date")
    public List<ShopDTO> getShops (@RequestBody ShopDTO shopDTO) {
        return shopService.getByDate(shopDTO);
    }

    @PostMapping
    public ShopDTO createShop (@Valid @RequestBody ShopDTO shopDTO) {
        return shopService.save(shopDTO);
    }

}
