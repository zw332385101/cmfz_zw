package com.baizhi.service;

import com.baizhi.dao.CourseDAO;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDAO courseDAO;
    @Override
    public List<Course> findByCourseAll() {
        List<Course> courses = courseDAO.queryByCourseAll();
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        course.setCreatTime(new Date());
        courseDAO.insertCourse(course);
    }

    @Override
    public void motifyCourse(Course course) {
        courseDAO.updateCourse(course);
    }

    @Override
    public void removeCourse(String id) {
        courseDAO.deleteCourse(id);
    }

    @Override
    public Course findByOne(String id) {
        Course course = courseDAO.queryByOne(id);
        return course;
    }
}
