package com.portfolio.portfolio.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateRequest extends UserAddRequest {
  @NotNull
  private Long id;
}
