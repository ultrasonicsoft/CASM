package org.casm.domain;

import java.util.List;

/**
 * Created by Shubham on 2/1/2016.
 */
public class ProductCatalogue {

    private List<Product> products;

    public ProductCatalogue(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
