package com.gy.jcartstore.dto.out.product;

public class ProductListOutDTO {
    private Integer productId;
    private String productName;
    private String productCode;
    private Double price;
    private Double discount;
    private Integer quantity;
    private Byte status;
    private String mainPicurl;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getMainPicurl() {
        return mainPicurl;
    }

    public void setMainPicurl(String mainPicurl) {
        this.mainPicurl = mainPicurl;
    }
}
