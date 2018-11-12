package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    //查询所有
    List<Course> findByCourseAll();
    //增加
    void addCourse(Course course);
    //修改
    void motifyCourse(Course course);
    //删除
    void removeCourse(String id);
    //查询一个
    Course findByOne(String id);
}
