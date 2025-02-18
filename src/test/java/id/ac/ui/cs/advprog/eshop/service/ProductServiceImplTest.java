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
        assertNotNull(createdProduct.getProductId());
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
    }

    @Test
    void testDeleteProduct() {
        String productId = "some-random-id";
        doNothing().when(productRepository).delete(productId);

        productService.delete(productId);

        verify(productRepository, times(1)).delete(productId);
    }
}
