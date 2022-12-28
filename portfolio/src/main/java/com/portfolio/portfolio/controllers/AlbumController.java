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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.portfolio.dto.AlbumRequest;
import com.portfolio.portfolio.dto.AlbumUpdateRequest;
import com.portfolio.portfolio.models.Album;
import com.portfolio.portfolio.models.Comment;
import com.portfolio.portfolio.service.AlbumService;
import com.portfolio.portfolio.service.CommentService;

@Controller
public class AlbumController {
  @Autowired
  private AlbumService albumService;
  @Autowired
  private CommentService commentService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String displayList(Model model) {
    List<Album> album = albumService.searchAll();
    model.addAttribute("album", album);
    return "album/index";
  }

  @GetMapping(value = "/album/new")
  public String displayAdd(Model model) {
    model.addAttribute("albumRequest", new AlbumRequest());
    return "album/new";
  }

  @GetMapping("/album/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    Album album = albumService.findOne(id);
    model.addAttribute("albumData", album);
    List<Comment> comment = commentService.searchAll();
    model.addAttribute("comment", comment);
    return "album/show";
  }

  @GetMapping("/album/edit/{id}")
  public String displayEdit(@PathVariable Long id, Model model) {
    Album album = albumService.findOne(id);
    AlbumUpdateRequest albumUpdateRequest = new AlbumUpdateRequest();
    albumUpdateRequest.setId(album.getId());
    albumUpdateRequest.setArtist(album.getArtist());
    albumUpdateRequest.setTitle(album.getTitle());
    albumUpdateRequest.setScore(album.getScore());
    albumUpdateRequest.setBody(album.getBody());
    model.addAttribute("albumUpdateRequest", albumUpdateRequest);
    return "album/edit";
  }

  @GetMapping("/album/delete/{id}")
  public String delete(@PathVariable Long id, Model model) {
    albumService.delete(id);
    return "redirect:/";
  }

  @RequestMapping(value = "/album/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute AlbumRequest albumRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "album/new";
    }
    // ユーザー情報の登録
    albumService.create(albumRequest);
    return "redirect:/";
  }

  @RequestMapping(value = "/album/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute AlbumUpdateRequest albumUpdateRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "album/edit";
    }
    albumService.update(albumUpdateRequest);
    return String.format("redirect:/album/%d", albumUpdateRequest.getId());
  }
}
