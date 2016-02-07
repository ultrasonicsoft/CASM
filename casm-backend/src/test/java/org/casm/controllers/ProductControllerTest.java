package org.casm.controllers;

import org.casm.Application;
import org.casm.contracts.ProductService;
import org.casm.domain.Product;
import org.casm.domain.ProductCatalogue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Shubham on 2/1/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    ProductService productServiceMock;

    @InjectMocks
    ProductController productController;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setup()
    {
        initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        List<Product> products = new ArrayList<>();
        products.add(new Product("New",90,90));
        doReturn(new ProductCatalogue(products)).when(productServiceMock).getAllProducts();
    }

    @Test
    public void getProductsResponseStatusShouldBeOk() throws Exception
    {
        this.mockMvc.perform(get("/product/getProducts")).andExpect(status().isOk());
    }

    @Test
    public void getProductsResponseShouldBeOFTypeJSON() throws Exception
    {
        this.mockMvc.perform(get("/product/getProducts")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getProductsResponseShouldContainJSONForProduct() throws Exception
    {
        //this.mockMvc.perform(get("/product/getProducts")).andExpect(jsonPath("products.[0].productName").value("Coke"));
    }

}
