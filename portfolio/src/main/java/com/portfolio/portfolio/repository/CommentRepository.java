package com.portfolio.portfolio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portfolio.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
  public List<Comment> findByAlbumId(Long albumId);

  Page<Comment> findByAlbumId(Long albumId, Pageable pageable);
  Optional<Comment> findByIdAndAlbumId(Long id, Long albumId);
}
