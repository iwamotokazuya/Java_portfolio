package com.portfolio.portfolio.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentAddRequest implements Serializable {
  @NotBlank(message = "コメントを入力してください")
  @Size(max = 300, message = "コメントは300字以内で入力してください")
    private String comment;
}
