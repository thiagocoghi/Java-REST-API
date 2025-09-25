package com.thiagocoghi.demo.service;

import com.thiagocoghi.demo.entity.Product;
import com.thiagocoghi.demo.exception.ResourceNotFoundException;
import com.thiagocoghi.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository repo;

  public ProductService(ProductRepository repo) {
    this.repo = repo;
  }

  public List<Product> findAll() { return repo.findAll(); }

  public Product findById(Long id) {
    return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
  }

  public Product create(Product product) { return repo.save(product); }

  public Product update(Long id, Product updated) {
    Product existing = findById(id);
    existing.setName(updated.getName());
    existing.setDescription(updated.getDescription());
    existing.setPrice(updated.getPrice());
    return repo.save(existing);
  }

  public void delete(Long id) { repo.deleteById(id); }
}
