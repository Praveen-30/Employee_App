package com.Employee.repository;

import com.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {

    List<Employee> getEmployeeByIdAndName(Long id , String name);

    Employee getEmployeeByAddress(String address);
    List<Employee> getEmployeeByName(String name);

}
