package com.rocketseat.courses.modules.courses.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rocketseat.courses.modules.courses.entitie.CourseEntitie;
import com.rocketseat.courses.modules.courses.repositorie.CourseRepositorie;

@Service
public class ListCoursesUseCase {
   private CourseRepositorie courseRepositorie;
  public ListCoursesUseCase(CourseRepositorie courseRepositorie){
    this.courseRepositorie = courseRepositorie;
  }
  public List<CourseEntitie> execute() {
    return this.courseRepositorie.findAll();
  }
}
