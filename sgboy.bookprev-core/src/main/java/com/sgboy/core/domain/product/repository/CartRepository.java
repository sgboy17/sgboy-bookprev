package com.sgboy.core.domain.product.repository;

import com.sgboy.core.domain.base.DBPRepository;
import com.sgboy.core.domain.product.Cart;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by NghiaPV on 7/1/2017.
 */
public interface CartRepository extends CrudRepository<Cart, Long>, DBPRepository<Cart> {

}
