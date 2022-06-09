package com.fabro;

public class Employee {
    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        Salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    private String name;
    private String dept;
    private int Salary;

}
