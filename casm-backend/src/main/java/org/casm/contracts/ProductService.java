package org.casm.contracts;

import org.casm.domain.product.ProductCatalogue;
import org.springframework.stereotype.Service;

/**
 * Created by Shubham on 2/1/2016.
 */
@Service
public interface ProductService {
    ProductCatalogue getAllProducts();
}
