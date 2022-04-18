package com.domain.algo.service;

import com.domain.algo.dto.SellerDTO;
import com.domain.algo.entity.Seller;

import java.util.List;

public interface SellerService {
    Seller addUser(SellerDTO sellerDTO) throws Exception;

    List<Seller> getAllSellers();
}
