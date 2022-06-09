package com.rafeed.eComDemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    @Id
    @SequenceGenerator(
            name = "brand_id_generator",
            sequenceName = "brand_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brand_id_generator"
    )
    @Column(
            name = "brand_id",
            nullable = false
    )
    private int brandId;

    @Column(
            name = "brand_name",
            nullable = false
    )
    private String brandName;

//    @ManyToOne
//    @JoinColumn(
//            name = "category_id",
//            nullable = true
//    )
//    private Category category;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Product>products;
}
