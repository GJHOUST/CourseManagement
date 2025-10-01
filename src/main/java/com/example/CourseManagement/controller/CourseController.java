package com.example.CourseManagement.controller;
import com.example.CourseManagement.models.dto.CourseCreateDTO;
import com.example.CourseManagement.models.dto.CourseViewDTO;
import com.example.CourseManagement.models.services.CourseServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseServiceImp courseServiceImp;


    @PostMapping("/create")
    public ResponseEntity<CourseViewDTO> create(@Valid @RequestBody CourseCreateDTO dto){
        CourseViewDTO savedCourse = courseServiceImp.createCourse(dto);
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseViewDTO>> getAllCourses(){
        return ResponseEntity.ok(courseServiceImp.getAllCourses());
    }

    @GetMapping("/getCourse/{courseId}")
    public ResponseEntity<CourseViewDTO> getCourseById(@PathVariable Long courseId){
        return ResponseEntity.ok(courseServiceImp.getCourseById(courseId));
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<CourseViewDTO> updateCourse(
            @PathVariable Long courseId,
            @RequestBody CourseCreateDTO dto) {
        return ResponseEntity.ok(courseServiceImp.updateCourse(courseId, dto));
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<Void> deleteCousreById(@PathVariable Long courseId){
        courseServiceImp.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

}
