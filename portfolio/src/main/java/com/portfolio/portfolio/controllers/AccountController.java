package com.portfolio.portfolio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.portfolio.form.UserRegistrationForm;
import com.portfolio.portfolio.service.UserRegistrationService;

@Controller
public class AccountController {
  @Autowired
  private UserRegistrationService userRegistrationService;

  @GetMapping("/login")
  public String showLoginPage() {
    return "login";
  }

  @GetMapping("/user/registration")
  public String showUserRegistration(@ModelAttribute("form") UserRegistrationForm form) {
    return "user-registration";
  }

  @PostMapping("/user/registration")
  public String userRegistration(@Valid @ModelAttribute("form") UserRegistrationForm form, BindingResult result) {
    if(result.hasErrors()) {
      return "user-registration";
    }
    userRegistrationService.userRegistration(form.getUsername(), form.getPassword());
    return "redirect:/login";
  }

  @RequestMapping("/afterLogout")
  String afterLogout() {
      return "afterLogout";
  }
}
