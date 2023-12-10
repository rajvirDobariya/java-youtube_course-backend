package com.springrest.controller;

import com.springrest.dto.CourseDTO;
import com.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/home")
    public ResponseEntity<Object> testing() {
        return new ResponseEntity<Object>("this is youtube courses", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAllCourses() {

        System.out.println("called...");
        return new ResponseEntity<Object>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable long id) throws Exception {
        return new ResponseEntity<Object>(courseService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.create(courseDTO);
        return new ResponseEntity<Object>("Course Created successfully",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable long id, @RequestBody CourseDTO courseDTO)
            throws Exception {
        return new ResponseEntity<Object>(courseService.update(id, courseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourseById(@PathVariable long id) throws Exception {
        return new ResponseEntity<Object>(courseService.delete(id), HttpStatus.OK);
    }
}
