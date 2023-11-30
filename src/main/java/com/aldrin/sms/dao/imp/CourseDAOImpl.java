/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.sms.dao.imp;


import com.aldrin.sms.dao.CourseDAO;
import com.aldrin.sms.entity.Course;
import com.aldrin.sms.uti.ComboBoxList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class CourseDAOImpl implements CourseDAO {

    @Override
    public void addCourse(Course course, EntityManager em) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateCourse(Course course, EntityManager em) {
        Course c = em.find(Course.class, course.getId());
        em.getTransaction().begin();
        c.setCourse(course.getCourse());
        c.setDescription(course.getDescription());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteCourse(Course course, EntityManager em) {
        Course r = em.find(Course.class, course.getId());
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();
    }

    public ArrayList<ComboBoxList> list;

    @Override
    public List<Course> selectCourse(EntityManager em) {
        List<Course> course = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        return course;
    }

    @Override
    public void comboBoxCourse(EntityManager em) {
        this.setList(new ArrayList<ComboBoxList>());
        List<Course> courseList = em.createQuery("SELECT c FROM Course c ORDER BY c.course ASC", Course.class).getResultList();
        for (Course r : courseList) {
            this.getList().add(new ComboBoxList(r.getId(), r.getCourse()+" ("+r.getDescription()+")"));
        }
    }

}
