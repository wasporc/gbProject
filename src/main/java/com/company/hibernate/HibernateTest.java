package com.company.hibernate;

public class HibernateTest {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        for (int i = 0; i < 1000; i++) {
            service.saveOrUpdate(new Student(null, "TestName" + i, "TestMark" + i));
        }
        //выделить всех
        System.out.println(service.getStudents());
        //конкретную запись
        System.out.println(service.getById(1));
        //удалить
        service.remove(new Student(1,"TestName1","TestMark1" ));
        //изменить
        service.saveOrUpdate(new Student(2,"TestName222","TestMark2222" ));

    }
}
