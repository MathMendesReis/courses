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

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(ApiRouters.COURSES)
public class ListCoursesController {
  @Autowired
  private ListCoursesUseCase listCoursesUseCase;
  @GetMapping()
  @Tag(name = "Cursos",description = "Lista todos os cursos")

  public ResponseEntity<Object> handle() {
    try {
      List<CourseEntitie> res = this.listCoursesUseCase.execute();
      return ResponseEntity.ok().body(res);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
