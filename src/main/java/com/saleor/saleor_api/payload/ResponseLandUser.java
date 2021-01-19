package com.saleor.saleor_api.payload;

public class ResponseLandUser {

    private  Long userId;
    private  Long landingId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLandingId() {
        return landingId;
    }

    public void setLandingId(Long landingId) {
        this.landingId = landingId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private  Long productId;

    private String productName;



}
