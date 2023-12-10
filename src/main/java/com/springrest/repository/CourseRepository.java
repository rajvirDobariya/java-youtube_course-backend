package com.springrest.repository;

import com.springrest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findById(long id);
	public List<Course> findAllByOrderByIdDesc();
}
