package org.casm.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Shubham on 2/1/2016.
 */
public class ProductCatalogue {

    @JsonProperty("products")
    private List<Product> products;

    @JsonCreator
    public ProductCatalogue(List<Product> products) {
        this.products = products;
    }
}
