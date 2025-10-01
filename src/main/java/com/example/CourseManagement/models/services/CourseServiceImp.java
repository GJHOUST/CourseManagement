package com.example.CourseManagement.models.services;
import com.example.CourseManagement.data.entities.Course;
import com.example.CourseManagement.data.repositories.CourseRepository;
import com.example.CourseManagement.models.dto.CourseCreateDTO;
import com.example.CourseManagement.models.dto.CourseViewDTO;
import com.example.CourseManagement.models.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public CourseViewDTO createCourse(CourseCreateDTO dto){
        Course course = courseMapper.toCourse(dto);
        courseRepository.save(course);
        return courseMapper.toView(course);

    }

    public List<CourseViewDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toView)
                .toList();
    }

    public CourseViewDTO getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Kurz nenalezen"));
        return courseMapper.toView(course);
    }

    public CourseViewDTO updateCourse(Long courseId, CourseCreateDTO dto) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Kurz nenalezen"));


        if (dto.getTitle() != null && !dto.getTitle().isBlank()) {
            course.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null && !dto.getDescription().isBlank()) {
            course.setDescription(dto.getDescription());
        }

        courseRepository.save(course);
        return courseMapper.toView(course);
    }


    public void deleteCourseById(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new IllegalArgumentException("Kurz nenalezen");
        }
        courseRepository.deleteById(courseId);
    }
}
