package com.saleor.saleor_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoProduct {

    private Long id;

    private String name;

    private String sku;

    private Boolean isActive;

    private String createdBy;

    Date createdDate ;

    private String modified_by;

    Date modifiedDate ;

    private String barcode;

    private String qrcode;

    private String content;

    private Double price;

    private Double salePrice;

    private String descs;

    private Double quantity_sold;

    private Double quantity_current;

    private List<String> images;

    private List<DtoProductProperties> dtoProductProperties= new ArrayList<>();

    private Long productCatogories_id;

    private String units;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Double getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(Double quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public Double getQuantity_current() {
        return quantity_current;
    }

    public void setQuantity_current(Double quantity_current) {
        this.quantity_current = quantity_current;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<DtoProductProperties> getProductProperties() {
        return dtoProductProperties;
    }

    public void setProductProperties(List<DtoProductProperties> dtoProductProperties) {
        this.dtoProductProperties = dtoProductProperties;
    }

    public Long getProductCatogories_id() {
        return productCatogories_id;
    }

    public void setProductCatogories_id(Long productCatogories_id) {
        this.productCatogories_id = productCatogories_id;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}

