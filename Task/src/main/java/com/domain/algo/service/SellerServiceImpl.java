package com.domain.algo.service;

import com.domain.algo.dto.SellerDTO;
import com.domain.algo.entity.Seller;
import com.domain.algo.entity.Users;
import com.domain.algo.repository.SellerRepository;
import com.domain.algo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Seller addUser(SellerDTO sellerDTO) throws Exception {
        //if user with gien id does not exist
        if(userRepository.existsById(sellerDTO.getUserId()) == false) {
            throw new Exception("user with id "+sellerDTO.getUserId()+" does not exist, provide a valid id");
        }

        //if a user is already a seller
        if(sellerRepository.findByUser_Id(sellerDTO.getUserId()) != null) {
            throw new Exception("this user is already a seller");
        }

        Users user = userRepository.getById(sellerDTO.getUserId());
        Seller seller = sellerRepository.save(new Seller(user));
        return seller;
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }
}
