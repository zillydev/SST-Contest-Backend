package com.zaid.fakestorecart.services;

import com.zaid.fakestorecart.models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreCartService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Cart> getAllCarts() {
        Cart[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                Cart[].class
        );

        return Arrays.stream(carts).toList();
    }

    public Cart getCart(Long id) {
        Cart cart = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                Cart.class
        );

        return cart;
    }

    public List<Cart> getUserCarts(Long userId) {
        Cart[] carts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/" + userId,
                Cart[].class
        );

        return Arrays.stream(carts).toList();
    }
}
