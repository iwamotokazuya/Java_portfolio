package com.portfolio.portfolio.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// import com.portfolio.portfolio.models.Album;

import lombok.Data;

@Data
public class CommentRequest implements Serializable {
  @NotBlank(message = "コメントを入力してください")
  @Size(max = 300, message = "コメントは300字以内で入力してください")
    private String comment;

    private Long albumId;

    // public Album getAlbum;
}
