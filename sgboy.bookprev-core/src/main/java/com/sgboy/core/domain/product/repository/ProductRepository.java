package com.sgboy.core.domain.product.repository;

import com.sgboy.core.domain.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by NghiaPV on 6/19/2017.
 */
@Component
public interface ProductRepository extends CrudRepository<Product, Long> {

    public Product findByName(String name);

}
