package com.domain.algo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @SequenceGenerator(name = "seller_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seller_sequence")
    @Column(name = "seller_id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "seller_product_id")
    @JsonIgnore
    private Set<Product> productSet = new HashSet<>();

    @OneToOne
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Seller() {
    }

    public Seller(Users user) {
//        this.productSet = productSet;
        this.user = user;
    }
}
