package com.thiagocoghi.demo.service;

import com.thiagocoghi.demo.entity.User;
import com.thiagocoghi.demo.exception.ResourceNotFoundException;
import com.thiagocoghi.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final UserRepository repo;

  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  public List<User> findAll() { return repo.findAll(); }

  public User findById(Long id) {
    return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
  }

  public User create(User user) { return repo.save(user); }

  public User update(Long id, User updated) {
    User existing = findById(id);
    existing.setName(updated.getName());
    existing.setEmail(updated.getEmail());
    existing.setRole(updated.getRole());
    return repo.save(existing);
  }

  public void delete(Long id) { repo.deleteById(id); }
}
