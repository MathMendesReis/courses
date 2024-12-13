package com.rocketseat.courses.modules.courses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class CreateCourseRequestDTO {
  @Schema(example = "Matheus Mendes", requiredMode = RequiredMode.REQUIRED)
  private String name;
  @Schema(example = "Tecnologia", requiredMode = RequiredMode.REQUIRED)
  private String category;
  @Schema(example = "true", requiredMode = RequiredMode.REQUIRED)
  private boolean active;

  public CreateCourseRequestDTO() {
  }

  public CreateCourseRequestDTO(String name, String category, boolean active) {
    this.name = name;
    this.category = category;
    this.active = active;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public boolean isActive() {
    return active;
  }

}
