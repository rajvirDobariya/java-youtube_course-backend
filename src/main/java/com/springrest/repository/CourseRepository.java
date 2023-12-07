package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

	public Course findById(long id);

	public List<Course> findAllByOrderByIdDesc();
}
