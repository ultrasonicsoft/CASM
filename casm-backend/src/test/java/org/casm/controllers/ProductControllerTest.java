package org.casm.controllers;

import org.casm.contracts.ProductService;
import org.casm.domain.product.Product;
import org.casm.domain.product.ProductCatalogue;
import org.casm.domain.enums.CrateType;
import org.casm.domain.enums.Packaging;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Shubham on 2/1/2016.
 */

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productServiceMock;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setup() {
        initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        List<Product> products = new ArrayList<>();
        products.add(new Product("New", 90, 90, Packaging.PLASTIC_BOTTLE, CrateType.CARD_BOARD, true));
        doReturn(new ProductCatalogue(products)).when(productServiceMock).getAllProducts();
    }

    @Test
    public void getProductsResponseStatusShouldBeOk() throws Exception {
        this.mockMvc.perform(get("/product/getProducts")).andExpect(status().isOk());
    }

    @Test
    public void getProductsResponseShouldBeOFTypeJSON() throws Exception {
        this.mockMvc.perform(get("/product/getProducts")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getProductsResponseShouldContainJSONForProduct() throws Exception {
        this.mockMvc.perform(get("/product/getProducts"))
                .andDo(print())
                .andExpect(jsonPath("$.products.[0].sellingPrice").value(90.0))
                .andExpect(jsonPath("$.products.[0].packaging").value(Packaging.PLASTIC_BOTTLE.toString()))
                .andExpect(jsonPath("$.products.[0].isActive").value(true));
    }
}
