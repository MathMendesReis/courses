package com.rocketseat.courses.modules.courses.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rocketseat.courses.modules.courses.dto.CreateCourseRequestDTO;
import com.rocketseat.courses.modules.courses.entitie.CourseEntitie;
import com.rocketseat.courses.modules.courses.useCases.CreatedCourseUseCase;
import com.rocketseat.courses.modules.courses.utils.ApiRouters;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(ApiRouters.COURSES)
public class CreateCourseController {
  @Autowired
  private CreatedCourseUseCase createdCourseUseCase;
  @PostMapping()
  @Operation(summary = "Cadastro de postagens", description = "Essa função é responsável por cadastrar uma postagem")
  @ApiResponses({
      @ApiResponse(responseCode = "201")
  })
  @Tag(name = "Cursos", description = "Registro de um novo curso")
  public ResponseEntity<?> handle(@RequestBody CreateCourseRequestDTO request) {
    try {
      this.createdCourseUseCase.execute(request);
      return new ResponseEntity<>(request, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

}
