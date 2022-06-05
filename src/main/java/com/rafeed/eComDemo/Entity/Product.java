package com.rafeed.eComDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    @Column(
            name = "product_id",
            nullable = false
    )
    private int product_id;

    @Column(
            name = "product_name",
            nullable = false
    )
    private String productName;

    @Column(
            name = "unit_price",
            nullable = false
    )
    private int unitPrice;

    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            nullable = false
    )
    private Brand brand;

    @ManyToOne
    @JoinColumn(
            name = "category_id",
            nullable = true
    )
    private Category category;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = true
    )
    private Customer customer;
}
