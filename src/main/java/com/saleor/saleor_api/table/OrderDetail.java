

package com.saleor.saleor_api.table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "money")
    private Double money;

    @Column(name = "price")
    private Double price;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name = "weight")
    private Float weight;

    @ManyToOne
    @JoinColumn(name = "orders_id",nullable = false)
    private Orders orders;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderDetail")
    private Set<Product> listProduct = new HashSet<>();

}