package com.sgboy.core.domain.product;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by NghiaPV on 6/7/2017.
 */
@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "CODE", length = 20)
    private String code;

    @Column(name = "NAME",  length = 50)
    private String name;

    @Column(name = "CATEGORY", length = 50)
    private String category;

    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "STATUS", length = 50)
    private String status;

    @Column(name= "UNIT_IN_STOCK")
    private int unitInStock;

    @Column(name = "MANUFACTURER", length = 200)
    private String manufacturer;

    @Transient
    private MultipartFile productImage;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;
}
