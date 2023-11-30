/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.sms.dao;

import com.aldrin.sms.entity.Student;
import java.util.List;
import javax.persistence.EntityManager;



/**
 *
 * @author ALDRIN B. C.
 */

public interface StudentDAO {
    
        
//  add Course
    public void addStudent(Student student, EntityManager em);
    
//   update Course
    public void updateStudent(Student student, EntityManager em);
    
//  delete Course
    public void deleteStudent(Student student, EntityManager em);
    
//  list of Course
    public List<Student> selectStudent(EntityManager em);
    
    public Student findPhotoByStudentId(Student student,EntityManager em);
    
}
