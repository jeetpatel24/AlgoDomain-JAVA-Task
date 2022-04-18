package com.domain.algo.repository;

import com.domain.algo.entity.Product;
import com.domain.algo.entity.Seller;
import com.domain.algo.entity.Users;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserRepository userRepository;

    Users user;
    Seller seller;

    @BeforeEach
    void setUp() {
        user = userRepository.save(new Users("user1", "user1@gmail.com"));
        seller = sellerRepository.save(new Seller(user));
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
        sellerRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void getByProductName() {

        List<Product> savedProduct = new ArrayList<>();
        savedProduct.add(productRepository.save(new Product("pname", "ptype1", "pcat1", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname", "ptype2", "pcat2", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname", "ptype3", "pcat3", 1000, seller)));

        List<Product> foundProduct = productRepository.getByProductName("pname");

        assertArrayEquals(savedProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray(),
                foundProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray());
    }

    @Test
    void getByProductType() {

        List<Product> savedProduct = new ArrayList<>();
        savedProduct.add(productRepository.save(new Product("pname1", "ptype", "pcat1", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname2", "ptype", "pcat2", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname3", "ptype", "pcat3", 1000, seller)));

        List<Product> foundProduct = productRepository.getByProductType("ptype");

        assertArrayEquals(savedProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray(),
                foundProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray());
    }

    @Test
    void getByCategory() {

        List<Product> savedProduct = new ArrayList<>();
        savedProduct.add(productRepository.save(new Product("pname1", "ptype1", "pcat", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname2", "ptype2", "pcat", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname3", "ptype3", "pcat", 1000, seller)));

        List<Product> foundProduct = productRepository.getByCategory("pcat");

        assertArrayEquals(savedProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray(),
                foundProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray());
    }

    @Test
    void getByPriceIsBetween() {

        List<Product> savedProduct = new ArrayList<>();
        savedProduct.add(productRepository.save(new Product("pname", "ptype1", "pcat1", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname", "ptype2", "pcat2", 2000, seller)));
        savedProduct.add(productRepository.save(new Product("pname", "ptype3", "pcat3", 3000, seller)));

        List<Product> foundProduct = productRepository.getByPriceIsBetween(1000, 3000);

        assertArrayEquals(savedProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray(),
                foundProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray());
    }

    @Test
    void getBySellerId() {

        List<Product> savedProduct = new ArrayList<>();
        savedProduct.add(productRepository.save(new Product("pname", "ptype1", "pcat1", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname", "ptype2", "pcat2", 1000, seller)));
        savedProduct.add(productRepository.save(new Product("pname", "ptype3", "pcat3", 1000, seller)));

        List<Product> foundProduct = productRepository.getBySellerId(seller.getId());

        assertArrayEquals(savedProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray(),
                foundProduct.stream().map(Product::getId).collect(Collectors.toList()).toArray());
    }
}