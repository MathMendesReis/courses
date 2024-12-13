package com.rocketseat.courses.modules.courses.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocketseat.courses.modules.courses.entitie.CourseEntitie;

import java.util.UUID;
public interface CourseRepositorie extends JpaRepository<CourseEntitie, UUID> {

  
} 
