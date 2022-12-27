package com.portfolio.portfolio.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AlbumRequest implements Serializable {
  @NotBlank(message = "アーティスト名を入力してください")
  @Size(max = 50, message = "アーティスト名は50字以内で入力してください")
    private String artist;

  @NotBlank(message = "アルバム名を入力してください")
  @Size(max = 50, message = "アルバム名は50字以内で入力してください")
    private String title;

  @NotNull(message = "得点を入力してください")
  @Min(0)
  @Max(value =100, message = "得点は100点以内で入力してください")
    private Long score;

  @NotBlank(message = "レビューを入力してください")
  @Size(max = 300, message = "レビューは300字以内で入力してください")
    private String body;
}
