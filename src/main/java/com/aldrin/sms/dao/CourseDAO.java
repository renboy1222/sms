/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.sms.dao;


import com.aldrin.sms.entity.Course;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ALDRIN B. C.
 */
public interface CourseDAO {

//  add Course
    public void addCourse(Course course, EntityManager em);

//   update Course
    public void updateCourse(Course course, EntityManager em);

//  delete Course
    public void deleteCourse(Course course, EntityManager em);

//  list of Course
    public List<Course> selectCourse(EntityManager em);

    public void comboBoxCourse(EntityManager em);

}
