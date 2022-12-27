package com.portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.models.User;
import com.portfolio.portfolio.repository.UserRepository;

@Service
public class UserRegistrationService {
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserRepository userRepository;

  public void userRegistration(String username, String password) {
    String hashedPassword = passwordEncoder.encode(password);
    userRepository.saveAndFlush(new User(username, hashedPassword, "GENERAL"));
  }
}
