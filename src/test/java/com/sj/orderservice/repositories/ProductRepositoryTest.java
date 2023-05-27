package com.sj.orderservice.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.sj.orderservice.domain.Product;
import com.sj.orderservice.utils.ProductStatus;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductRepositoryTest {
  @Autowired
  private ProductRepository productRepository;

  @Test
  public void testSaveProduct_Success() {
    final Product product = Product.builder()
        .productDescription("firstProduct")
        .productStatus(ProductStatus.NEW)
        .build();

    final Product savedProduct = productRepository.save(product);

    final Optional<Product> fetchedProduct = productRepository.findById(savedProduct.getId());
    assertNotNull(fetchedProduct.get().getId());
    assertNotNull(fetchedProduct.get().getProductStatus());
    assertNotNull(fetchedProduct.get().getCreatedDate());
    assertNotNull(fetchedProduct.get().getLastModifiedDate());
  }

}