package com.rocketseat.courses.modules.courses.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rocketseat.courses.modules.courses.dto.UpdateCourseRequestDTO;
import com.rocketseat.courses.modules.courses.entitie.CourseEntitie;
import com.rocketseat.courses.modules.courses.exceptions.CourseNotFoundException;
import com.rocketseat.courses.modules.courses.repositorie.CourseRepositorie;

@Service
public class UpdateCourserUseCase {
  private CourseRepositorie courseRepositorie;
  public UpdateCourserUseCase(CourseRepositorie courseRepositorie){
    this.courseRepositorie = courseRepositorie;
  }
  public void execute(UpdateCourseRequestDTO request, UUID id) {
    CourseEntitie courseEntitie = this.courseRepositorie.findById(id).orElseThrow(()->{
      throw new CourseNotFoundException();
    });
    if (request.getName() != null) {
      courseEntitie.setName(request.getName());
    }
    if (request.getCategory() != null) {
      courseEntitie.setCategory(request.getCategory());
    }
    this.courseRepositorie.save(courseEntitie);
  }
}
