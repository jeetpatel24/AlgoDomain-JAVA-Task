package com.domain.algo.repository;

import com.domain.algo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getByProductName(String name);
    List<Product> getByProductType(String type);
    List<Product> getByCategory(String category);

    @Query(value = "select * from product where price BETWEEN :minPrice AND :maxPrice", nativeQuery = true)
    List<Product> getByPriceIsBetween(Integer minPrice, Integer maxPrice);

    List<Product> getBySellerId(Long id);

}
