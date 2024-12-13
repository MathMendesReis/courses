package com.rocketseat.courses.modules.courses.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.courses.modules.courses.dto.UpdateCourseRequestDTO;
import com.rocketseat.courses.modules.courses.useCases.UpdateCourserUseCase;
import com.rocketseat.courses.modules.courses.utils.ApiRouters;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(ApiRouters.COURSES)
public class UpdateCourserController {
  @Autowired
  private UpdateCourserUseCase updateCourserUseCase;
  @PutMapping("/{id}")
  @Tag(name = "Cursos",description = "Atualiza o nome e a categoria de um curso") 
  public ResponseEntity<?> handle(@PathVariable("id") UUID id, @RequestBody UpdateCourseRequestDTO request) {
    try {
      this.updateCourserUseCase.execute(request,id);
      return new ResponseEntity<>(request, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
