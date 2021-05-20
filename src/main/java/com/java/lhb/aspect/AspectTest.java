package com.java.lhb.aspect;

/**
 * @author harryper
 * @date 2020/8/20
 */
public class AspectTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        EmployeeAspect test = new EmployeeAspect();
        employee.work();
    }
}
