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
    private int productId;

    @Column(
            name = "product_name",
            nullable = false
    )
    private String productName;

    @Column(
            name = "product_specs"
    )
    private String productSpecs;

    @Column(
            name = "unit_price",
            nullable = false
    )
    private int unitPrice;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "brand_id",
            nullable = false
    )
    private Brand brand;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "category_id",
            nullable = false
    )
    private Category category;
}
