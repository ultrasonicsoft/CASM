package org.casm.domain.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.casm.domain.enums.CrateType;
import org.casm.domain.enums.Packaging;

/**
 * Created by Shubham on 2/1/2016.
 */
public class Product {

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("sellingPrice")
    private double sellingPrice;

    @JsonProperty("costPrice")
    private double costPrice;

    @JsonProperty("packaging")
    private Packaging packaging;

    @JsonProperty("crateType")
    private CrateType crateType;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonCreator
    public Product(String productName, double sellingPrice, double costPrice, Packaging packaging, CrateType crateType, boolean isActive) {
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.packaging = packaging;
        this.crateType = crateType;
        this.isActive = isActive;
    }
}
