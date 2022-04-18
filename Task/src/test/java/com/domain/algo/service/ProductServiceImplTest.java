package com.domain.algo.service;

import com.domain.algo.dto.ProductDTO;
import com.domain.algo.entity.Product;
import com.domain.algo.entity.Seller;
import com.domain.algo.entity.Users;
import com.domain.algo.repository.ProductRepository;
import com.domain.algo.repository.SellerRepository;
import com.domain.algo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    SellerRepository sellerRepository;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    ProductServiceImpl productService;


    Users user;
    Seller seller;
    @BeforeEach
    void setUp() {
        user = new Users("user1", "user1@gmail.com");
        userRepository.save(user);
        seller = new Seller(user);
        sellerRepository.save(seller);
    }

    @Test
    void addProduct() {
    }

    @Test
    void getAllProducts() {

        //given
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(productRepository.save(new Product("pname1", "ptype1", "pcat1", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname2", "ptype2", "pcat2", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname3", "ptype3", "pcat3", 1000, seller)));

        when(productRepository.findAll()).thenReturn(expectedProductList);
        List<Product> actualProductList = productService.getAllProducts();

        assertEquals(expectedProductList, actualProductList);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getAllProductsByName() {

        //given
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(productRepository.save(new Product("pname", "ptype1", "pcat1", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname", "ptype2", "pcat2", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname", "ptype3", "pcat3", 1000, seller)));

        when(productRepository.getByProductName("pname")).thenReturn(expectedProductList);
        List<Product> actualProductList = productService.getAllProductsByName("pname");

        assertEquals(expectedProductList, actualProductList);
        verify(productRepository, times(1)).getByProductName("pname");
    }

    @Test
    void getAllProductsByType() {

        //given
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(productRepository.save(new Product("pname1", "ptype", "pcat1", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname2", "ptype", "pcat2", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname3", "ptype", "pcat3", 1000, seller)));

        when(productRepository.getByProductType("ptype")).thenReturn(expectedProductList);
        List<Product> actualProductList = productService.getAllProductsByType("ptype");

        assertEquals(expectedProductList, actualProductList);
        verify(productRepository, times(1)).getByProductType("ptype");
    }

    @Test
    void getAllProductsByCategory() {

        //given
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(new Product("pname1", "ptype1", "pcat", 1000, seller));
        expectedProductList.add(new Product("pname2", "ptype2", "pcat", 1000, seller));
        expectedProductList.add(new Product("pname3", "ptype3", "pcat", 1000, seller));

        when(productRepository.getByCategory("pcat")).thenReturn(expectedProductList);
        List<Product> actualProductList = productService.getAllProductsByCategory("pcat");

        assertEquals(expectedProductList, actualProductList);
        verify(productRepository, times(1)).getByCategory("pcat");
    }

    @Test
    void getAllProductsByPriceRange() {

        //given
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(new Product("pname1", "ptype1", "pcat1", 1000, seller));
        expectedProductList.add(new Product("pname2", "ptype2", "pcat2", 2000, seller));
        expectedProductList.add(new Product("pname3", "ptype3", "pcat3", 3000, seller));

        when(productRepository.getByPriceIsBetween(1000,3000)).thenReturn(expectedProductList);
        List<Product> actualProductList = productService.getAllProductsByPriceRange(1000, 3000);

        assertEquals(expectedProductList, actualProductList);
        verify(productRepository, times(1)).getByPriceIsBetween(1000, 3000);
    }

    @Test
    @Disabled
    void updateProduct() {
    }

    @Test
    @Disabled
    void deleteProduct() {

    }

    @Test
    void getAllProductsWithGivenSellerId() {

        //given
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(productRepository.save(new Product("pname1", "ptype1", "pcat1", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname2", "ptype2", "pcat2", 1000, seller)));
        expectedProductList.add(productRepository.save(new Product("pname3", "ptype3", "pcat3", 1000, seller)));

        when(productRepository.getBySellerId(seller.getId())).thenReturn(expectedProductList);
        List<Product> actualProductList = productService.getAllProductsWithGivenSellerId(seller.getId());

        assertEquals(expectedProductList, actualProductList);
        verify(productRepository, times(1)).getBySellerId(seller.getId());
    }
}