/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.sms.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class HibernateConfig {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public HibernateConfig() {
        this.setFactory(Persistence.createEntityManagerFactory("sis"));
    }

    public EntityManager getEntityManager() {
        return entityManager = new HibernateConfig().getFactory().createEntityManager();
    }

    public void closeConnection() {
        entityManager.close();
        getFactory().close();
    }

}
