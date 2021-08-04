package com.company;

import com.company.lists.LinkedList;
import com.company.lists.MyIterator;
import com.company.lists.MyList;

public class Main {

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .age(10)
                .address("address")
                .country("country")
                .lastName("Last Name")
                .middleName("Middle Name")
                .gender("Robot")
                .phone("Phone")
                .firstName("First Name")
                .build();
        System.out.println(person);

        Shape[] shapes = new Shape[]{
                new Circle(),
                new Triangle(),
                new Square()
        };

        for (Shape shape : shapes) {
            shape.draw();
        }

        MyList<String> myList = new LinkedList<>();
        myList.add("one");
        myList.add("two");
        myList.add("three");

        MyIterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println(myList.get(1));

    }
}
