package com.company;

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

    }
}
