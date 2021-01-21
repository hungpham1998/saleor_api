package com.saleor.saleor_api.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ref_product_images")
    private List<String> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Unit_id")
    private Units units;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ImportTicketDetail> importTicketDetails;

    @ManyToOne
    @JoinColumn(name = "product_catogories_id", nullable = false)
    @JsonIgnoreProperties("products")
    private ProductCatogories productCatogories;


    //   unit 1-n product
//    @JsonIgnore
//    @OneToMany(mappedBy = "product_properties", fetch = FetchType.LAZY)
//    private Set<ProductProperties> productProperties ;
}
