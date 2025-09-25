package com.thiagocoghi.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagocoghi.demo.entity.Product;
import com.thiagocoghi.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService service;

  public ProductController(ProductService service) { this.service = service; }

  @GetMapping
  public List<Product> getAll() { return service.findAll(); }

  @GetMapping("/{id}")
  public Product getById(@PathVariable Long id) { return service.findById(id); }

  @PostMapping
  public ResponseEntity<Product> create(@Validated @RequestBody Product product) {
    Product created = service.create(product);
    return ResponseEntity.created(URI.create("/api/products/" + created.getId())).body(created);
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable Long id, @Validated @RequestBody Product product) {
    return service.update(id, product);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
