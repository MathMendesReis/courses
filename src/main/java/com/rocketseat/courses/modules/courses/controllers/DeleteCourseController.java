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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(ApiRouters.COURSES)
public class DeleteCourseController {
  @Autowired
  private DeleteCourseUseCase deleteCourseUseCase;

  @DeleteMapping("/{id}")
  @Tag(name = "Cursos",description = "Deleta um curso")
  @Operation(summary = "Deleção de curso", description = "Essa função é responsável por deletar um curso na base de dados")
  @ApiResponses({
      @ApiResponse(responseCode = "204")
  })
  public ResponseEntity<?> handle(@PathVariable UUID id) {
    try {
      this.deleteCourseUseCase.execute(id);
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
