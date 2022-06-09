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


        // Java 8 - Interview Items
        userDefindFilter();

        // Java -x - Extra items
       // userIterate();

    }

    private static void userIterate() {
        List<Employee> employees=Arrays.asList(new Employee("frank", "DEV","active",50000),
                new Employee("Ramesh", "DEV","inactive",40000),
                new Employee("Dinesh", "QA","active",80000),
                new Employee("Archana", "QA","active",20000),
                new Employee("Mohan", "DEVOPS","active",100000));

        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println(employees.toString());

    }

    private static void userDefindFilter() {

        List<Employee> employees=Arrays.asList(new Employee("frank", "DEV","active",50000),
                                               new Employee("Ramesh", "DEV","inactive",40000),
                                               new Employee("Dinesh", "QA","active",80000),
                                               new Employee("Archana", "QA","active",20000),
                                               new Employee("Mohan", "DEVOPS","active",100000));

        // Question 1 - get the employees in list vice
        Map<String,List<Employee>> mapList=  employees.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.toList()));
        System.out.println(mapList.toString());

        // Question 2 - get the employees in dept vice , Count
        Map<String,Long>  mapList1=  employees.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
        System.out.println(mapList1);

        // Question 3 - Active and Inactive Count
        long countActive = employees.stream().filter(employee -> employee.getActive().equals("active")).count();
        System.out.println("active -> "+countActive);
        long countInactive= employees.stream().filter(employee -> employee.getActive().equals("inactive")).count();
        System.out.println("inactive -> "+countInactive);

        // Question 4 - Min and Max Salary
        Optional<Employee>  empmax= employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println("empmax -> "+empmax);

        Optional<Employee>  empMin= employees.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println("empMin -> "+empMin);

        // Question 5 - Min and Max Salary
        Map<String,Optional<Employee>> empList5= employees.stream().collect(Collectors
                .groupingBy(Employee::getDept, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        System.out.println(empList5.toString());


//        Comparator<Employee> employeeComparator=Comparator.comparing(Employee::getDept);
//
//               Map<String, Optional<Employee>> empsMap= employees.stream().collect(Collectors.groupingBy(
//                        Employee::getDept,Collectors.reducing(BinaryOperator.maxBy(employeeComparator))));
//        System.out.println(empsMap.toString());



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

        List<String> lists = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(lists);

        List<String> emails=   users.stream().flatMap(User->User.getEmail().stream()).collect(Collectors.toList());
        System.out.println(emails);

    }
}
