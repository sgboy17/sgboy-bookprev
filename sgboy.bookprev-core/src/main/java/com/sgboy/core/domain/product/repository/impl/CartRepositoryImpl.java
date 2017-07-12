package com.sgboy.core.domain.product.repository.impl;

import com.sgboy.core.domain.base.DBPRepository;
import com.sgboy.core.domain.product.Cart;
import com.sgboy.core.domain.product.repository.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NghiaPV on 7/1/2017.
 */
@Repository
public class CartRepositoryImpl implements DBPRepository<Cart> {

    private Map<String, Cart> listOfCarts;

    public CartRepositoryImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(String sessionId) {
        if (listOfCarts.keySet().contains(sessionId)) {
            throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the given session_Id(%) " +
                    "already " + "exists", sessionId));
        }

        Cart cart = new Cart();
        listOfCarts.put(sessionId, cart);

        return cart;
    }

    public Cart read(String sessionId){
        return listOfCarts.get(sessionId);
    }


    public void update(String sessionId, Cart cart) {
        if (!listOfCarts.keySet().contains(sessionId)) {
            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the given id(%) " +
                    "does not " + "exist", sessionId));
        }

        listOfCarts.put(sessionId, cart);
    }

    public void delete (String sessionId) {
        if (!listOfCarts.keySet().contains(sessionId)) {
            throw new IllegalArgumentException(String.format("Can not delete cart. A cart with the given id(%) " +
                    "does not " +
                    "exist", sessionId));
        }

        listOfCarts.remove(sessionId);
    }

}
