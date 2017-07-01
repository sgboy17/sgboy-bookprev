package com.sgboy.core.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NghiaPV on 6/30/2017.
 */

@Entity
@Getter
@Setter
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", length = 200)
    private String name;
    @Column(name = "EMAIL", length = 200)
    private String email;
    @Column(name = "PHONE", length = 200)
    private String phone;

    @Column(name = "USERNAME", length = 200)
    private String username;

    @Column(name = "ENABLED")
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "billingAddress")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shoppingAddress")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "cart")
    @JsonIgnore
    private Cart cart;


}
