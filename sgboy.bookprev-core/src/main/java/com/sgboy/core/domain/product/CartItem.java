package com.sgboy.core.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NghiaPV on 6/30/2017.
 */
@Entity
@Getter
@Setter
@Table(name = "CART_ITEM")
public class CartItem implements Serializable {

    public static final long serialVersionUID = 1L;

    public CartItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", insertable = false, updatable = false)
    private long id;

//    @ManyToOne
//    @JoinColumn(name = "id")
//    @JsonIgnore
//    private Cart cart;


    @ManyToOne
    @JoinColumn(name = "product")
    @JsonIgnore
    private Product product;

}
