package com.example.CourseManagement.models.services;

import com.example.CourseManagement.models.dto.CourseCreateDTO;
import com.example.CourseManagement.models.dto.CourseViewDTO;

import java.util.List;

public interface CourseService {

     CourseViewDTO createCourse(CourseCreateDTO dto);
     List<CourseViewDTO> getAllCourses();
     CourseViewDTO getCourseById(Long courseId);
     CourseViewDTO updateCourse(Long courseId, CourseCreateDTO dto);
     void deleteCourseById(Long courseId);

}
