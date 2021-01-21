package com.saleor.saleor_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoProduct {

    private Long id;

    private String name;

    private String sku;

    private String createdBy;

    private String modified_by;

    private String barcode;

    private String qrcode;

    private String content;

    private Double price;

    private Double salePrice;

    private String descs;

    private List<String> catogories;
    public DtoProduct(long id, String sku, String name, String createdBy, String modified_by, List<String> catogories, String barcode, String qrcode, String content,Double price,Double salePrice,String descs) {
        this.id = id;
        this.sku = sku;
        this.name=name;
        this.createdBy=createdBy;
        this.modified_by=modified_by;
        this.qrcode=qrcode;
        this.barcode=barcode;
        this.content=content;
        this.price=price;
        this.salePrice=salePrice;
        this.descs=descs;
        this.catogories=catogories;
    }
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
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

    public List<String> getCatogories() {
        return catogories;
    }

    public void setCatogories(List<String> catogories) {
        this.catogories = catogories;
    }
}
