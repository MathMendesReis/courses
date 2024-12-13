package com.rocketseat.courses.modules.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.courses.modules.courses.entitie.CourseEntitie;
import com.rocketseat.courses.modules.courses.useCases.ListCoursesUseCase;
import com.rocketseat.courses.modules.courses.utils.ApiRouters;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(ApiRouters.COURSES)
public class ListCoursesController {
  @Autowired
  private ListCoursesUseCase listCoursesUseCase;
  @GetMapping()
  @Tag(name = "Cursos",description = "Lista todos os cursos")
  @ApiResponses({
        @ApiResponse(responseCode = "200",content = {
           @Content(array = @ArraySchema(schema = @Schema(implementation = CourseEntitie.class)))
        })
    })
  public ResponseEntity<Object> handle() {
    try {
      List<CourseEntitie> res = this.listCoursesUseCase.execute();
      return ResponseEntity.ok().body(res);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
