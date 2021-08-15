package com.company.hibernate;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentService {
    private static final EntityManagerFactory factory;
    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public List<Student> getStudents(){
        return getEntityManager().createQuery("select s from Student s", Student.class).getResultList();
    }

    public Student getById(int id){
        return getEntityManager().find(Student.class, id);
    }

    public void remove(Student student){
        if (student != null) {
            getEntityManager().remove(student);
        }
    }

    public Student saveOrUpdate(Student student){
        if (student != null) {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            if (student.getId() == null) {
                em.persist(student);
            }else {
                em.merge(student);
            }
            em.getTransaction().commit();
            return student;
        }else {
            return null;
        }
    }


}
