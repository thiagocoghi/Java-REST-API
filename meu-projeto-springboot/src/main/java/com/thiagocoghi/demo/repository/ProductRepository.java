package com.thiagocoghi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagocoghi.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
