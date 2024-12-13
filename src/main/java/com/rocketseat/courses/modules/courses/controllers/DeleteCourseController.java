package com.rocketseat.courses.modules.courses.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.courses.modules.courses.useCases.DeleteCourseUseCase;
import com.rocketseat.courses.modules.courses.utils.ApiRouters;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(ApiRouters.COURSES)
public class DeleteCourseController {
  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @DeleteMapping("/{id}")
  @Tag(name = "Cursos",description = "Deleta um curso pelo seu id")

  public ResponseEntity<?> handle(@PathVariable UUID id) {
    try {
      this.deleteCourseUseCase.execute(id);
      return new ResponseEntity<>(null, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
