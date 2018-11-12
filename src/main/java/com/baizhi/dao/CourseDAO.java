package com.baizhi.dao;


import com.baizhi.entity.Course;

import java.util.List;

public interface CourseDAO {
    //查询所有
    List<Course> queryByCourseAll();
    //增加
    void insertCourse(Course course);
    //修改
    void updateCourse(Course course);
    //删除
    void deleteCourse(String id);
    //查询一个
    Course queryByOne(String id);

}
