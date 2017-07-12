package com.sgboy.web.controller;

import com.sgboy.core.domain.product.Cart;
import com.sgboy.core.domain.product.CartItem;
import com.sgboy.core.domain.product.Product;
import com.sgboy.core.domain.product.repository.CartRepository;
import com.sgboy.core.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NghiaPV on 7/1/2017.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/{sessionId}", method= RequestMethod.GET)
    public @ResponseBody Cart read (@PathVariable(value ="sessionId") String sessionId) {
        return cartRepository.read(sessionId);
    }

    @RequestMapping(value="/{sessionId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "sessionId" ) String sessionId, @RequestBody Cart cart) {
        cartRepository.update(sessionId, cart);
    }

    @RequestMapping(value="/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value = "productId") long productId, HttpServletRequest request) {
        String sessionId  = request.getSession(true).getId();
        System.out.println(sessionId);
        Cart cart = cartRepository.read(sessionId);

        if(cart == null) {
            cart = cartRepository.create(sessionId);
        }

        Product product =  productRepository.findOne(productId);
        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }

        CartItem cartItemTmp = new CartItem();
        cartItemTmp.setProduct(product);


        List<CartItem> cartItemListTmp;
        if(cart.getCartItems() != null)
        {
            cartItemListTmp = new ArrayList<CartItem>(cart.getCartItems());
        }
        else
        {
            cartItemListTmp = new ArrayList<CartItem>();
        }

        cartItemListTmp.add(cartItemTmp);

        cart.setCartItems(cartItemListTmp);

        cartRepository.update(sessionId, cart);
    }

    @RequestMapping(value = "/{sessionId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value="sessionId") String sessionId) {
        cartRepository.delete(sessionId);
    }


}
