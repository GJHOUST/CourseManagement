package com.example.CourseManagement.data.repositories;
import com.example.CourseManagement.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
