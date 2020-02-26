package com.gy.jcartstore.dto.in;

public class StoreUpdateProfileDTO {
    private String product_name;
    private String product_abstract;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_abstract() {
        return product_abstract;
    }

    public void setProduct_abstract(String product_abstract) {
        this.product_abstract = product_abstract;
    }
}
