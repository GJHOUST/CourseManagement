package com.example.CourseManagement.models.mappers;

import com.example.CourseManagement.data.entities.Course;
import com.example.CourseManagement.models.dto.CourseCreateDTO;
import com.example.CourseManagement.models.dto.CourseViewDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toCourse(CourseCreateDTO dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        return course;
    }

    public CourseViewDTO toView(Course course) {
        CourseViewDTO dto = new CourseViewDTO();
        dto.setCourseId(course.getCourseId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        return dto;
    }
}
