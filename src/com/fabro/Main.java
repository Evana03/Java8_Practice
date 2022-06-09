package com.fabro;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {




 //      MuFunctionalInterface muFunctionalInterface = (s1, s2) -> s1;

//        GooglePay gp=new GooglePay();
//        System.out.println(gp.doPayment());
//        System.out.println(gp.doScratchCard());

     //   Java8
     //    javaStream();

         // Java 8 - String frequency
     //     JavaStringFrequency();


        // Java 8
        userDefindFilter();

    }

    private static void userDefindFilter() {

        List<Employee> employees=Arrays.asList(new Employee("frank", "DEV",50000),
                                               new Employee("Ramesh", "DEV",40000),
                                               new Employee("Dinesh", "QA",80000),
                                               new Employee("Archana", "QA",20000),
                                               new Employee("Mohan", "DEVOPS",100000));
        Comparator<Employee> employeeComparator=Comparator.comparing(Employee::getDept);

               Map<String, Optional<Employee>> empsMap= employees.stream().collect(Collectors.groupingBy(
                        Employee::getDept,Collectors.reducing(BinaryOperator.maxBy(employeeComparator))));
        System.out.println(empsMap.toString());



    }

    private static void JavaStringFrequency() {

        String name="franklin";
       Map<String,Long> map= Arrays.stream(name.split("")).collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        ));
        System.out.println(map);

    }








    // usage of map & flatMap
    private static void javaStream() {
        List<User> users= Arrays.asList(new User("frank","9566092990",Arrays.asList("frank@gmail.com","jino@yahoo.com")),
                                        new User("Evana","9884426646",Arrays.asList("evana@gmail.com","kezi@yahoo.com")));

        List<String> lists = users.stream().map(User-> User.getName()).collect(Collectors.toList());
        System.out.println(lists);

        List<String> emails=   users.stream().flatMap(User->User.getEmail().stream()).collect(Collectors.toList());
        System.out.println(emails);

    }
}
