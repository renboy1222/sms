/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.sms.dao.imp;


import com.aldrin.sms.dao.StudentDAO;
import com.aldrin.sms.entity.Student;
import com.aldrin.sms.uti.ComboBoxList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class StudentDAOImpl implements StudentDAO {

    @Override
    public void addStudent(Student student, EntityManager em) {
        em.getTransaction().begin();;
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateStudent(Student student, EntityManager em) {
        Student s = em.find(Student.class, student.getId());
        em.getTransaction().begin();;
        s.setFirstname(student.getFirstname());
        s.setSurname(student.getSurname());
        s.setGender(student.getGender());
        s.setMobileNo(student.getMobileNo());
        s.setEmail(student.getEmail());
        s.setDate_of_birth(student.getDate_of_birth());
        s.setPhoto(student.getPhoto());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteStudent(Student student, EntityManager em) {
        Student u = em.find(Student.class, student.getId());
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }

    public ArrayList<ComboBoxList> list;
    @Override
//    "ID", "COURSE ID", "FIRST NAME", "SURNAME", "COURSE", "MOBILE", "EMAIL", "ADDRESS", "DATE OF BIRTH", "DATE OF BIRTHF"
    public List<Student> selectStudent(EntityManager em) {
//        List<Student> student = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        List<Student> student = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return student;
    }

    @Override
    public Student findPhotoByStudentId(Student student, EntityManager em) {
        Student studentPhoto= null;
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class);
        query.setParameter("id", student.getId());
        //error
        try {
            studentPhoto= query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("No student photo");
        }
        return studentPhoto;
    }

}
