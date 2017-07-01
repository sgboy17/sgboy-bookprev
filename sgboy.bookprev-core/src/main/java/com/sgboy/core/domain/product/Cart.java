package com.sgboy.core.domain.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by NghiaPV on 6/30/2017.
 */
@Entity
@Getter
@Setter
@Table(name = "CART")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    public Cart() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customer")
    @JsonIgnore
    private Customer customer;

    @Column(name = "GRAND_TOTAL")
    private double grandTotal;


}
