package com.rafeed.eComDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_sequence"
    )
    @Column(
            name = "category_id",
            nullable = false
    )
    private int categoryId;

    @Column(
            name = "category_name",
            nullable = false
    )
    private String categoryName;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Brand>brands;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Product>productList;
}
