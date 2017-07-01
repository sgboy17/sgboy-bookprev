package com.sgboy.web.controller;

import com.sgboy.core.domain.product.CartItem;
import com.sgboy.core.domain.product.Product;
import com.sgboy.core.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        System.out.println("hello test livereloadhhghfhjfj");
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "home/home";
    }

    @RequestMapping(value = "/single/{productId}", method = RequestMethod.GET)
    public String single(@PathVariable  long productId, Model model){
        Product product = productRepository.findOne(productId);
        model.addAttribute("product", product);
        model.addAttribute("test", "abc");
        return "home/single";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model){
        Product product = new Product();
        product.setCode("PR1");
        product.setName("Product 1");
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        for (int i = 0; i < 3; i++) {
            CartItem cartItemTmp = new CartItem();
            cartItemList.add(cartItemTmp);
        }
        product.setCartItems(cartItemList);
        productRepository.save(product);
        return "home/single";
    }
}
