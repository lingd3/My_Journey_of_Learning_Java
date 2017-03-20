package com.dan.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.dan.mvcdemo.model.Course;

@Service
public interface CourseService {
	Course getCoursebyId(Integer courseId);
}
