package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /*
     *查询所有
     * */
    @RequestMapping("/findByCourseAll")
    public @ResponseBody List<Course> findByCourseAll(){
        List<Course> byCourseAll = courseService.findByCourseAll();
        return byCourseAll;
    }

    @RequestMapping("/addCourse")
    public @ResponseBody void addCourse(Course course){
        courseService.addCourse(course);
    }

    @RequestMapping("/motifyCourse")
    public @ResponseBody void motifyCourse(Course course){
        courseService.motifyCourse(course);
    }

    @RequestMapping("/removeCourse")
    public @ResponseBody void removeCourse(String id){
        courseService.removeCourse(id);
    }
}
