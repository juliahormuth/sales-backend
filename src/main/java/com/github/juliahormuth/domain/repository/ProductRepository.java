package com.github.juliahormuth.domain.repository;

import com.github.juliahormuth.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer> {
}
