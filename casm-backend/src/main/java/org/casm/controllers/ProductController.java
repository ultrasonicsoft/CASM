package org.casm.controllers;

import org.casm.contracts.ProductService;
import org.casm.domain.product.ProductCatalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shubham on 2/1/2016.
 */

@RestController
@RequestMapping("product")
public class ProductController {

    ProductService productService;

    @Autowired
    ProductController(@Qualifier("live") ProductService productService)
    {
        this.productService = productService;
    }

    @RequestMapping("/getProducts")
    public ResponseEntity<ProductCatalogue> getProduct()
    {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }
}
