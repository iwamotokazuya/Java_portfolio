package com.portfolio.portfolio.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AlbumUpdateRequest extends AlbumRequest implements Serializable {
  @NotNull
  private Long id;
}
