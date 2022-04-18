package com.domain.algo.controller;

import com.domain.algo.dto.ProductDTO;
import com.domain.algo.entity.Product;
import com.domain.algo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.addProduct(productDTO);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/add/list")
    public ResponseEntity addProduct(@RequestBody List<ProductDTO> productDTOList) {

        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productDTOList) {
            Product product = productService.addProduct(productDTO);
            products.add(product);
        }
        return ResponseEntity.ok().body(products);
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<Product> list = productService.getAllProducts();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity getAllProductsWithGivenSellerId(@PathVariable Long id) {
        List<Product> list = productService.getAllProductsWithGivenSellerId(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get/byname")
    public ResponseEntity getAllProductsByName(@RequestParam String productName) {
        List<Product> list = productService.getAllProductsByName(productName);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get/bytype")
    public ResponseEntity getAllProductsByType(@RequestParam String productType) {
        List<Product> list = productService.getAllProductsByType(productType);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get/bycat")
    public ResponseEntity getAllProductsByCategory(@RequestParam String productCat) {
        List<Product> list = productService.getAllProductsByCategory(productCat);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/get/bypricerange")
    public ResponseEntity getAllProductsByPriceRange(@RequestParam Integer minPrice, @RequestParam Integer maxPrice ) {
        List<Product> list = productService.getAllProductsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        try {
            Product product = productService.updateProduct(id, productDTO);
            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        try {
            String res = productService.deleteProduct(id, productDTO);
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

}
