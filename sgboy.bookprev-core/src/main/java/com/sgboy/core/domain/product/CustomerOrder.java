package com.sgboy.core.domain.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NghiaPV on 7/1/2017.
 */
@Entity
@Getter
@Setter
@Table(name ="CUSTOMER_ORDER")
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    public CustomerOrder() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @OneToOne
    @JoinColumn(name = "CART")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "BILLINGADDRESS")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name="SHIPPINGADDRESS")
    private ShippingAddress shippingAddress;

}
