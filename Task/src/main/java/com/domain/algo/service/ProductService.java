package com.domain.algo.service;

import com.domain.algo.dto.ProductDTO;
import com.domain.algo.entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductDTO productDTO);

    List<Product> getAllProducts();

    List<Product> getAllProductsByName(String productName);

    List<Product> getAllProductsByType(String productType);

    List<Product> getAllProductsByCategory(String productCat);

    List<Product> getAllProductsByPriceRange(Integer minPrice, Integer maxPrice);

    Product updateProduct(Long id, ProductDTO productDTO) throws Exception;

    String deleteProduct(Long id, ProductDTO productDTO) throws Exception;

    List<Product> getAllProductsWithGivenSellerId(Long id);
}
