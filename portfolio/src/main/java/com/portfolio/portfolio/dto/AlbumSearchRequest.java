package com.portfolio.portfolio.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlbumSearchRequest implements Serializable {
  private String id;

  private String artist;
}
