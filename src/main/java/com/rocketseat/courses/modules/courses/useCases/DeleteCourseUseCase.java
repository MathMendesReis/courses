package com.rocketseat.courses.modules.courses.useCases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rocketseat.courses.modules.courses.repositorie.CourseRepositorie;

@Service
public class DeleteCourseUseCase {
  private CourseRepositorie courseRepositorie;
  public DeleteCourseUseCase(CourseRepositorie courseRepositorie){
    this.courseRepositorie = courseRepositorie;
  }
  public void execute(UUID id) {
    this.courseRepositorie.deleteById(id);
  }
}
