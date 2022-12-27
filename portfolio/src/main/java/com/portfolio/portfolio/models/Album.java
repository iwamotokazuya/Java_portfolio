package com.portfolio.portfolio.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Data
@Table(name="album")
public class Album {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="artist")
  private String artist;

  @Column(name="title")
  private String title;

  @Column(name="score")
  private Long score;

  @Column(name="body")
  private String body;

  @Column(name = "update_date")
  private Date updateDate;

  @Column(name = "create_date")
  private Date createDate;

  @Column(name = "delete_date")
  private Date deleteDate;

  @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
  private List<Comment> commentList;
}
