package com.domain.algo.dto;

public class ProductDTO {

    private String productName;
    private String productType;
    private String category;
    private Integer price;
    private Long sellerId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public ProductDTO(String productName, String productType, String category, Integer price, Long sellerId) {
        this.productName = productName;
        this.productType = productType;
        this.category = category;
        this.price = price;
        this.sellerId = sellerId;
    }
}
