package com.example.CourseManagement.controller;
import com.example.CourseManagement.models.dto.CourseCreateDTO;
import com.example.CourseManagement.models.dto.CourseViewDTO;
import com.example.CourseManagement.models.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/create")
    public ResponseEntity<CourseViewDTO> create(@Valid @RequestBody CourseCreateDTO dto){
        CourseViewDTO savedCourse = courseService.createCourse(dto);
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseViewDTO>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/getCourse/{courseId}")
    public ResponseEntity<CourseViewDTO> getCourseById(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<CourseViewDTO> updateCourse(
            @PathVariable Long courseId,
            @RequestBody CourseCreateDTO dto) {
        return ResponseEntity.ok(courseService.updateCourse(courseId, dto));
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<Void> deleteCousreById(@PathVariable Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

}
