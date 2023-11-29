package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.springrest.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	public Course findById(long id);
	public List<Course> findAllByOrderByIdDesc();
}
