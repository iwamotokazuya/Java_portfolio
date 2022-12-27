package com.portfolio.portfolio.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.dto.CommentRequest;
import com.portfolio.portfolio.dto.CommentUpdateRequest;
import com.portfolio.portfolio.models.Comment;
import com.portfolio.portfolio.repository.CommentRepository;

@Service
public class CommentService {
  @Autowired
  CommentRepository commentRepository;

  public List<Comment> searchAll() {
    return commentRepository.findAll();
  }

  public void create(CommentRequest commentRequest) {
    Date now = new Date();
    Comment comment = new Comment();
    comment.setComment(commentRequest.getComment());
    comment.setCreateDate(now);
    comment.setUpdateDate(now);
    commentRepository.save(comment);
  }

  public Comment findOne(Long id) {
    Optional<Comment> album = commentRepository.findById(id);
    if(album.isPresent()) {
      return album.get();
    } else {
      return null;
    }
  }

  public Comment save(Comment comment) {
    return commentRepository.save(comment);
  }

  public void delete(Long id) {
    Comment comment = findOne(id);
    commentRepository.delete(comment);
  }

  public void update(CommentUpdateRequest commentUpdateRequest) {
    Comment comment = findOne(commentUpdateRequest.getId());
    comment.setComment(commentUpdateRequest.getComment());
    comment.setUpdateDate(new Date());
    commentRepository.save(comment);
  }
}
