package com.zero.controller;

import com.zero.dao.CourseDAO;
import com.zero.entity.Course;
import com.zero.entity.CourseList;
import com.zero.entity.CourseMap;
import com.zero.entity.CourseSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: zero
 * @Description: Date:Create: in 2019/8/26 19:32
 * Modified By:
 */

@Controller
public class DataBindController {

    @Autowired
    private CourseDAO courseDAO;

    /**
     * 基本数据类型
     * @param id
     * @return
     */
    @RequestMapping("/baseType")
    @ResponseBody
    public String baseType(@RequestParam(value = "id",required = false) int id){
        return "id:"+id;
    }

    /**
     * 包装类
     * @param id
     * @return
     */
    @RequestMapping(value = "/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "id",required = false) Integer id){ // required: 允许传入参数为空
        return "id:"+id; // Integer包装类可以赋值为null，所以不会报错
    }

    /**
     * 数组类型
     * @param name
     * @return
     */
    @RequestMapping(value = "/arrayType")
    @ResponseBody
    public String arrayType(String[] name){
        StringBuffer sbf = new StringBuffer();
        for (String item:name){
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    /**
     * pojo对象类型
     * @param course
     * @return
     */
    @RequestMapping(value = "/pojoType")
    public ModelAndView pojoType(Course course){
        courseDAO.add(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }

    /**
     * list列表类型
     * @param courseList
     * @return
     */
    @RequestMapping(value = "/listType")
    public ModelAndView listType(CourseList courseList){
        for(Course course:courseList.getCourses()){
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }

    /**
     * map集合类型
     * @param courseMap
     * @return
     */
    @RequestMapping(value = "/mapType")
    public ModelAndView mapType(CourseMap courseMap){
        for(String key:courseMap.getCourses().keySet()){
            Course course = courseMap.getCourses().get(key);
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }

    /**
     * set集合类型
     * @param courseSet
     * @return
     */
    @RequestMapping(value = "/setType")
    public ModelAndView setType(CourseSet courseSet){
        for (Course course:courseSet.getCourses()){
            courseDAO.add(course);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }

    /**
     * json数据类型
     * @param course
     * @return
     */
    @RequestMapping(value = "/jsonType")
    @ResponseBody
    public  Course jsonType(@RequestBody Course course){
        course.setPrice(course.getPrice()+100);
        return course;
    }
}
