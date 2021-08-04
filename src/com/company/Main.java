package com.company;

import com.company.lists.ArrayList;
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
        myList.remove("two");
        MyIterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println(myList.get(1));


        MyList<Integer> myArray = new ArrayList<>(2);
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.remove(2);
        for (int i = 0; i < myArray.size(); i++){
            System.out.println(myArray.get(i));
        }

    }
}
