package com.rafeed.eComDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_id_sequence",
            sequenceName = "cart_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_id_sequence"
    )
    @Column(
            name = "cart_id",
            nullable = false
    )
    private int cartId;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customer_id",
            nullable = false
    )
    private Customer customer;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "product_id",
            nullable = false
    )
    private Product product;

    @Column(
            name = "quantity",
            nullable = false
    )
    private int quantity;
}
