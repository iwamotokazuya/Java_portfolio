package com.portfolio.portfolio.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserAddRequest implements Serializable {

  @NotBlank(message = "名前を入力してください")
  @Size(max = 30, message = "名前は30字以内で入力してください")
  private String username;

  @NotBlank(message = "メールを入力してください")
  @Email
  @Size(max = 30, message = "メールは30字以内で入力してください")
  private String email;

  @NotBlank(message = "メールを入力してください")
  @Size(min = 5, max = 30, message = "パスワードは5字以上30字以内で入力してください")
  private String password;
}
