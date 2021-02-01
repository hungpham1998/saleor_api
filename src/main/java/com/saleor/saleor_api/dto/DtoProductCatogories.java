package com.saleor.saleor_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saleor.saleor_api.table.Product;
import com.saleor.saleor_api.table.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoProductCatogories {

    private Long id;

    private String title;

    private String code;

    private Boolean isActive;

    private String createBy;

    Date createdDate = new Date();

    private String modifiedBy;

    Date modifiedDate = new Date();
//
//    private WareHouse wareHouse;
//
//    private Set<Product> products;
}
