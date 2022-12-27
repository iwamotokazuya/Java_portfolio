package com.portfolio.portfolio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.portfolio.dto.CommentRequest;
import com.portfolio.portfolio.repository.AlbumRepository;
import com.portfolio.portfolio.service.CommentService;

import lombok.RequiredArgsConstructor;

import com.portfolio.portfolio.repository.CommentRepository;

@RequiredArgsConstructor
@Controller
public class CommentController {
  @Autowired
  private CommentService commentService;

  @Autowired
  CommentRepository commentRepository;
  @Autowired
  AlbumRepository albumRepository;

  @GetMapping(value = "/comment/new")
  public String displayAdd(Model model) {
    model.addAttribute("commentRequest", new CommentRequest());
    return "comment/new";
  }

  @RequestMapping(value = "/comment/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute CommentRequest commentRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "comment/new";
    }
    // ユーザー情報の登録
    commentService.create(commentRequest);
    return "redirect:/album/index";
  }
}
