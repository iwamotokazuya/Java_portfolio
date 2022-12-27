package com.portfolio.portfolio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portfolio.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public User findByUsername(String username);
}
