package com.rocketseat.courses.modules.courses.useCases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rocketseat.courses.modules.courses.dto.UpdateActiveRequestDTO;
import com.rocketseat.courses.modules.courses.entitie.CourseEntitie;
import com.rocketseat.courses.modules.courses.exceptions.CourseNotFoundException;
import com.rocketseat.courses.modules.courses.repositorie.CourseRepositorie;

@Service
public class PacthActiveValueUseCase {
  private CourseRepositorie courseRepositorie;

  public PacthActiveValueUseCase(CourseRepositorie courseRepositorie) {
    this.courseRepositorie = courseRepositorie;
  }

  public void execute(UpdateActiveRequestDTO request, UUID id) {
    CourseEntitie courseEntitie = this.courseRepositorie.findById(id).orElseThrow(() -> {
      throw new CourseNotFoundException();
    });
    courseEntitie.setActive(request.isActive());
    this.courseRepositorie.save(courseEntitie);

  }
}
