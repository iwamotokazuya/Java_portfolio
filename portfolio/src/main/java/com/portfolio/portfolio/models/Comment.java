package com.portfolio.portfolio.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Data
@Table(name="comment")
public class Comment {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="comment")
  private String comment;

  @Column(name = "update_date")
  private Date updateDate;

  @Column(name = "create_date")
  private Date createDate;

  @Column(name = "delete_date")
  private Date deleteDate;

  @ManyToOne
  @JoinColumn(name = "album_id", referencedColumnName = "id")
  private Album album;
}
