package com.saleor.saleor_api.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")// tênSP
    private String name;

    @Column(name = "sku")
    private String sku;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "createdBy")
    private String createdBy;

    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate ;

    @Column(name = "modified_by")
    private String modified_by;

    @Basic(optional = false)
    @Column(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    Date modifiedDate ;

    @Column(name = "barcode") // mô tả sp
    private String barcode;

    @Column(name = "qrcode") // mô tả sp
    private String qrcode;

    @Column(name = "content") // mô tả sp
    private String content;

    @Column(name = "price")// giá
    private Double price;

    @Column(name = "salePrice")// giá giảm
    private Double salePrice;

    @Column(name = "descs") // mô tả sp
    private String descs;

    @Column(name = "quantity_sold") //Số lượng đã bán
    private Double quantity_sold;

    @Column(name = "quantity_current") // Số lượng hiện tại
    private Double quantity_current;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ref_product_images")
    private List<String> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Unit_id")
    private Units units;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductProperties> listProductProperties = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "orderDetail_id",nullable = false)
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "importTicketDetail_id",nullable = false)
    private ImportTicketDetail importTicketDetail;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "ref_product_preperies",
            joinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_catogories_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<ProductCatogories> productCatogories;
}
