package org.casm.MockServices;

import org.casm.contracts.ProductService;
import org.casm.domain.Product;
import org.casm.domain.ProductCatalogue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham on 2/1/2016.
 */

@Component
@Qualifier("live")
public class ProductServiceMock implements ProductService{

    @Override
    public ProductCatalogue getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Coke", 100, 90));
        products.add(new Product("Sprite", 100, 90));
        products.add(new Product("Limca", 100, 90));
        return new ProductCatalogue(products);
    }
}
