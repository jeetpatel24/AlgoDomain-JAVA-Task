package com.domain.algo.service;

import com.domain.algo.dto.ProductDTO;
import com.domain.algo.entity.Product;
import com.domain.algo.entity.Seller;
import com.domain.algo.repository.ProductRepository;
import com.domain.algo.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Seller seller = sellerRepository.getById(productDTO.getSellerId());
        Product product = productRepository.save(new Product(productDTO.getProductName(), productDTO.getProductType(), productDTO.getCategory(), productDTO.getPrice(), seller));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByName(String productName) {
        return productRepository.getByProductName(productName);
    }

    @Override
    public List<Product> getAllProductsByType(String productType) {
        return productRepository.getByProductType(productType);
    }

    @Override
    public List<Product> getAllProductsByCategory(String productCat) {
        return productRepository.getByCategory(productCat);
    }

    @Override
    public List<Product> getAllProductsByPriceRange(Integer minPrice, Integer maxPrice) {
        return productRepository.getByPriceIsBetween(minPrice, maxPrice);
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) throws Exception {
        Product product = productRepository.findById(id).get();

        if(product == null) {
            throw new Exception("No value present");
        }

        if(product.getSeller().getId() != productDTO.getSellerId()) {
            throw new Exception("only product seller can update its product details");
        }

        if(productDTO.getProductName() != null) product.setProductName(productDTO.getProductName());
        if(productDTO.getProductType() != null) product.setProductName(productDTO.getProductType());
        if(productDTO.getPrice() != null) product.setPrice(productDTO.getPrice());
        if(productDTO.getCategory() != null) product.setCategory(productDTO.getCategory());
        productRepository.save(product);

        return product;
    }

    @Override
    public String deleteProduct(Long id, ProductDTO productDTO) throws Exception {
        Product product = productRepository.findById(id).get();

        if(product == null) {
            throw new Exception("No value present");
        }

        if(product.getSeller().getId() != productDTO.getSellerId()) {
            throw new Exception("only product seller can delete its product details");
        }

        productRepository.deleteById(id);
        return "product deleted successfully";
    }

    @Override
    public List<Product> getAllProductsWithGivenSellerId(Long id) {
        return productRepository.getBySellerId(id);
    }
}
