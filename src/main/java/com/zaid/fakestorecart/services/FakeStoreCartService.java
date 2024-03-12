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

    public Cart addCart(Cart cart) {

        return restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                cart,
                Cart.class
        );
    }

    public Cart updateCart(Long id, Cart cart) {
        restTemplate.put("https://fakestoreapi.com/carts/" + id,
                cart, Cart.class);
        return getCart(id);
    }

    public Cart deleteCart(Long id) {
        restTemplate.delete("https://fakestoreapi.com/carts/" + id);
        return getCart(id);
    }
}
