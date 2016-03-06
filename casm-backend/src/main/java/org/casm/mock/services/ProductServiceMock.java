package org.casm.mock.services;

import org.casm.contracts.ProductService;
import org.casm.domain.product.Product;
import org.casm.domain.product.ProductCatalogue;
import org.casm.domain.enums.CrateType;
import org.casm.domain.enums.Packaging;
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
        products.add(new Product("Coke", 100, 90, Packaging.GLASS_BOTTLE, CrateType.PLASTIC, true));
        products.add(new Product("Limca", 200, 90, Packaging.GLASS_BOTTLE, CrateType.PLASTIC, false));
        products.add(new Product("Sprite", 300, 90, Packaging.GLASS_BOTTLE, CrateType.PLASTIC, false));

        return new ProductCatalogue(products);
    }
}
