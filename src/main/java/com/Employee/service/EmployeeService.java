package com.Employee.service;

import com.Employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    Employee updateEmployee(Long id , Employee employee);
    Employee updateEmployeeaddress(Long id ,Employee employee);
    List<Employee> getEmployeeByIdAndName(Long id ,String name);
    List<Employee> getEmployeeByName(String name);
    Employee updateEmployeeName(Long id ,Employee employee);
    Employee getEmployeeByAddress(String address);
    void deleteAll();



}
