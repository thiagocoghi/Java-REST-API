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

import com.thiagocoghi.demo.entity.User;
import com.thiagocoghi.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService service;

  public UserController(UserService service) { this.service = service; }

  @GetMapping
  public List<User> getAll() { return service.findAll(); }

  @GetMapping("/{id}")
  public User getById(@PathVariable Long id) { return service.findById(id); }

  @PostMapping
  public ResponseEntity<User> create(@Validated @RequestBody User user) {
    User created = service.create(user);
    return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(created);
  }

  @PutMapping("/{id}")
  public User update(@PathVariable Long id, @Validated @RequestBody User user) {
    return service.update(id, user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
