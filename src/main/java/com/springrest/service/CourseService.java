package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.dto.CourseDTO;
import com.springrest.entity.Course;
import com.springrest.exception.CourseException;
import com.springrest.repository.CourseRepository;

@Service

public class CourseService{

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAll(){
		return courseRepository.findAllByOrderByIdDesc();
	}

	public Course getById(long id) throws Exception {
		Course course = courseRepository.findById(id);
		if (course == null) {
			throw new CourseException("Course not found!");
		}
		return course;
	}

	public void create(CourseDTO courseDTO){
		Course course = new Course();

		course.setTitle(courseDTO.getTitle());
		course.setDescription(courseDTO.getDescription());
		courseRepository.save(course);
	}

	public Course update(long id, CourseDTO courseDTO) throws Exception {

		Course course = courseRepository.findById(id);
		if (course == null) {
			throw new CourseException("Course not found!");
		}

		course.setTitle(courseDTO.getTitle());
		course.setDescription(courseDTO.getDescription());
		return courseRepository.save(course);
	}

	public String delete(long id) throws Exception {
		Course course = courseRepository.findById(id);

		if (course == null) {
			throw new CourseException("Course not found!");
		}
		courseRepository.delete(course);
		return "Course deleted succesfully!";
	}

}