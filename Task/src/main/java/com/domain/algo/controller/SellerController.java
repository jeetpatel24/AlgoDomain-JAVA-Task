package com.domain.algo.controller;

import com.domain.algo.dto.SellerDTO;
import com.domain.algo.entity.Seller;
import com.domain.algo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity addSeller(@RequestBody SellerDTO sellerDTO) {
        try {
            Seller seller = sellerService.addUser(sellerDTO);
            return ResponseEntity.ok().body(seller);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAllSellers() {
        List<Seller> list = sellerService.getAllSellers();
        return ResponseEntity.ok().body(list);
    }
}
