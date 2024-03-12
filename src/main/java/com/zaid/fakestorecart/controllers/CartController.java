package com.zaid.fakestorecart.controllers;

import com.zaid.fakestorecart.models.Cart;
import com.zaid.fakestorecart.models.Product;
import com.zaid.fakestorecart.services.FakeStoreCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CartController {
    private final FakeStoreCartService cartService;

    public CartController(FakeStoreCartService productService) {
        this.cartService = productService;
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getCart(@PathVariable("id") Long id) {
        return cartService.getCart(id);
    }

    @GetMapping("/carts/user/{id}")
    public List<Cart> getUserCarts(@PathVariable("id") Long userId) {
        return cartService.getUserCarts(userId);
    }

    @PostMapping("/carts")
    public Cart addCart(Cart cart) {
        return cartService.addCart(cart);
    }

    @PutMapping("/carts/{id}")
    public Cart updateCart(@PathVariable("id") Long id, @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id") Long id) {
        return cartService.deleteCart(id);
    }
}
