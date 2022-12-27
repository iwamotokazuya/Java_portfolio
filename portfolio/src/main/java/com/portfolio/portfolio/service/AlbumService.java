package com.portfolio.portfolio.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.dto.AlbumRequest;
import com.portfolio.portfolio.dto.AlbumUpdateRequest;
import com.portfolio.portfolio.models.Album;
import com.portfolio.portfolio.repository.AlbumRepository;

@Service
public class AlbumService {
  @Autowired
  AlbumRepository albumRepository;

  public List<Album> searchAll() {
    return albumRepository.findAll();
  }

  public void create(AlbumRequest albumRequest) {
    Date now = new Date();
    Album album = new Album();
    album.setArtist(albumRequest.getArtist());
    album.setTitle(albumRequest.getTitle());
    album.setScore((long) albumRequest.getScore());
    album.setBody(albumRequest.getBody());
    album.setCreateDate(now);
    album.setUpdateDate(now);
    albumRepository.save(album);
  }

  public Album findOne(Long id) {
    Optional<Album> album = albumRepository.findById(id);
    if(album.isPresent()) {
      return album.get();
    } else {
      return null;
    }
  }

  public Album save(Album album) {
    return albumRepository.save(album);
  }

  public void delete(Long id) {
    Album album = findOne(id);
    albumRepository.delete(album);
  }

  public void update(AlbumUpdateRequest albumUpdateRequest) {
    Album album = findOne(albumUpdateRequest.getId());
    album.setArtist(albumUpdateRequest.getArtist());
    album.setTitle(albumUpdateRequest.getTitle());
    album.setScore((long) albumUpdateRequest.getScore());
    album.setBody(albumUpdateRequest.getBody());
    album.setUpdateDate(new Date());
    albumRepository.save(album);
  }
}
