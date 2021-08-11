package com.company.hibernate;

import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManagerFactory;

public class StudentService {
    private static final EntityManagerFactory factory;
    static {
        factory = new Configuration()
                .configure("hibernate.xml")
                .buildSessionFactory();
    }
}
