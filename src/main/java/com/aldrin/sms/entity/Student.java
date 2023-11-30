/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.sms.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
@ToString
@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String surname;
    private String mobileNo;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;

    @Column(length = 16777215)
    private byte[] photo; 

    public Student(){
        
    }
    public Student(Long id,String firstname,String surname, Course course, Gender gender,String mobile,String email,String address,Date dof){
       
    }
}
