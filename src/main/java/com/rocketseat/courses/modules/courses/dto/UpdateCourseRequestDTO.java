package com.rocketseat.courses.modules.courses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class UpdateCourseRequestDTO {
  @Schema(example = "Matheus Mendes", requiredMode = RequiredMode.NOT_REQUIRED)
  private String name;
  @Schema(example = "Tecnologia", requiredMode = RequiredMode.NOT_REQUIRED)
  private String category;

  public UpdateCourseRequestDTO(String name, String category) {
    this.name = name;
    this.category = category;
  }

  public UpdateCourseRequestDTO() {
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

}
