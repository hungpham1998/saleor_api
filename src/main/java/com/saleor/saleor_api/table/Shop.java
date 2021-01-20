package com.saleor.saleor_api.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "shop")
public class Shop {
    @Id
    @Column( name = "id", nullable = false, unique = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "manager", nullable = false)
    private String manager;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "image")
    private String image;

    @OneToOne(mappedBy = "shop")
    private WareHouse wareHouse;

    @Column(name = "district_id",nullable = false)
    private String district_id;

    @Column(name = "province_id",nullable = false)
    private String province_id;

    @Column(name = "ward_id",nullable = false)
    private String ward_id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

}
