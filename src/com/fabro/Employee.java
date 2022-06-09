package com.fabro;

public class Employee {

    private String name;
    private String dept;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", active='" + active + '\'' +
                ", Salary=" + Salary +
                '}';
    }

    private String active;
    private int Salary;

    public Employee(String name, String dept, String active, int salary) {
        this.name = name;
        this.dept = dept;
        this.active = active;
        this.Salary = salary;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
