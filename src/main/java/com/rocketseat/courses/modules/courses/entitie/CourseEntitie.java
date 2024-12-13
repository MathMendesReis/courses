package com.rocketseat.courses.modules.courses.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rocketseat.courses.modules.courses.dto.CreateCourseRequestDTO;

import java.time.LocalDateTime;
@Entity
@Table(name = "courses")
public class CourseEntitie {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String name;
  private String category;
  @Column()
  private boolean active;
  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @UpdateTimestamp
  @Column(name = "update_at")
  private LocalDateTime updatedAt;
  public CourseEntitie() {
  }
  public CourseEntitie(CreateCourseRequestDTO request) {
    this.setName(request.getName());
    this.setCategory(request.getCategory());
    this.setActive(request.isActive());
  }
  public CourseEntitie(String name, String category) {
    this.setName(name);
    this.setCategory(category);
    this.setActive(true);
  }
  public UUID getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public boolean isActive() {
    return active;
  }
  public void setActive(boolean active) {
    this.active = active;
  }
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
