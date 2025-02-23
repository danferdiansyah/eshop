package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setProductName("Laptop");
        product.setProductQuantity(10);

        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertNotNull(createdProduct);
        assertEquals("Laptop", createdProduct.getProductName());
        assertEquals(10, createdProduct.getProductQuantity());

        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAllProducts() {
        Product product1 = new Product();
        product1.setProductName("Laptop");
        product1.setProductQuantity(10);

        Product product2 = new Product();
        product2.setProductName("Phone");
        product2.setProductQuantity(5);

        Iterator<Product> iterator = Arrays.asList(product1, product2).iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> productList = productService.findAll();

        assertEquals(2, productList.size());
        assertEquals("Laptop", productList.get(0).getProductName());
        assertEquals("Phone", productList.get(1).getProductName());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testDeleteProduct() {
        String productId = "some-random-id";
        doNothing().when(productRepository).delete(productId);

        productService.deleteById(productId);

        verify(productRepository, times(1)).delete(productId);
    }

    @Test
    void testFindProductById_Found() {
        Product product = new Product();
        product.setProductName("Laptop");
        product.setProductQuantity(10);
        product.setProductId("1234");

        Iterator<Product> iterator = Arrays.asList(product).iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        Product foundProduct = productService.findById("1234");

        assertNotNull(foundProduct);
        assertEquals("1234", foundProduct.getProductId());
        assertEquals("Laptop", foundProduct.getProductName());
    }

    @Test
    void testFindProductById_NotFound() {
        Iterator<Product> iterator = Collections.emptyIterator();
        when(productRepository.findAll()).thenReturn(iterator);

        Product foundProduct = productService.findById("non-existent-id");

        assertNull(foundProduct);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setProductId("1234");
        product.setProductName("Laptop");
        product.setProductQuantity(10);

        when(productRepository.update("1234", product)).thenReturn(product);

        productService.update("1234", product);

        verify(productRepository, times(1)).update("1234", product);
    }
}