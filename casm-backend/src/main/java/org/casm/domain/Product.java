package org.casm.domain;

/**
 * Created by Shubham on 2/1/2016.
 */
public class Product{

    private String productName;
    private double sellingPrice;
    private double costPrice;

    public Product(String productName, double sellingPrice, double costPrice) {
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }
}
