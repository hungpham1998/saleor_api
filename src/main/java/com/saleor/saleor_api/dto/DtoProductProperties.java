package com.saleor.saleor_api.dto;

import com.saleor.saleor_api.table.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoProductProperties {
    private Long id;

    private String product_key;

    private String product_value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_key() {
        return product_key;
    }

    public void setProduct_key(String product_key) {
        this.product_key = product_key;
    }

    public String getProduct_value() {
        return product_value;
    }

    public void setProduct_value(String product_value) {
        this.product_value = product_value;
    }
}
