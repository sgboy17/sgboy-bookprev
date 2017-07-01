package com.sgboy.core.domain.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NghiaPV on 7/1/2017.
 */

@Entity
@Getter
@Setter
@Table(name ="BILLING_ADDRESS")
public class BillingAddress implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "STREET_NAME", length = 200)
    private String streetName;
    @Column(name = "APARTMENT_NUMBER", length = 200)
    private String apartmentNumber;
    @Column(name = "CITY", length = 200)
    private String city;
    @Column(name = "STATE", length = 200)
    private String state;
    @Column(name = "COUNTRY", length = 200)
    private String country;
    @Column(name = "ZIP_CODE", length = 200)
    private String zipCode;

    @OneToOne
    @JoinColumn(name="customer")
    private Customer customer;

}
