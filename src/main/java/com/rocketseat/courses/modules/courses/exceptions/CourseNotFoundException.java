package com.rocketseat.courses.modules.courses.exceptions;


public class CourseNotFoundException extends RuntimeException {
  public CourseNotFoundException() {
    super("Curso não encontrado");
  }
}
