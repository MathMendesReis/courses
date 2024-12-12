package com.rocketseat.courses.modules.courses.useCases;

import org.springframework.stereotype.Service;

import com.rocketseat.courses.modules.courses.dto.CreateCourseRequestDTO;
import com.rocketseat.courses.modules.courses.entitie.CourseEntitie;
import com.rocketseat.courses.modules.courses.repositorie.CourseRepositorie;

@Service
public class CreatedCourseUseCase {
  private CourseRepositorie courseRepositorie;
  public CreatedCourseUseCase(CourseRepositorie courseRepositorie){
    this.courseRepositorie = courseRepositorie;
  }
  public void execute(CreateCourseRequestDTO request) {
    CourseEntitie courseEntitie = new CourseEntitie(request);
    this.courseRepositorie.save(courseEntitie);
  }
}
