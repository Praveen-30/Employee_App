package com.Employee.service.impl;

import com.Employee.entity.Employee;
import com.Employee.repository.EmployeeRepository;
import com.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
    public Employee saveEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> emp = employeeRepository.findAll();
        return emp;

    }

    @Override
    public Employee getEmployeeById(Long id) {
                   Optional<Employee> optionalEmployee= employeeRepository.findById(id);
                   if(optionalEmployee.isPresent())
                   {
                     return  optionalEmployee.get();
                   }

else
    throw new RuntimeException("Invalid id ! try again");

    }

    @Override
    public void deleteEmployeeById(Long id) {
        Optional<Long> opId = Optional.ofNullable(id);
        if(opId.isPresent())
        {
            opId.get();
        }
        Employee emp=employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid Id"));

            employeeRepository.deleteById(id);


    }


    @Override
    public Employee updateEmployee(Long id, Employee employee) {
                 Optional<Long> optionalEmploye=Optional.ofNullable(id);
                 if(optionalEmploye.isPresent())
                 {
                     System.out.println(optionalEmploye.get());
                 }
        Employee emp=employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid Id"));
        if(Objects.nonNull(emp.getName()) && !"".equalsIgnoreCase(emp.getName()))
        {
            emp.setName(employee.getName());
        }
        if(Objects.nonNull(emp.getAddress()) && !"".equalsIgnoreCase(emp.getAddress()))
        {
            emp.setAddress(employee.getAddress());
        }

       return employeeRepository.save(emp);
    }



   @Override
    public Employee updateEmployeeaddress(Long id, Employee employee) {
       Employee existingEmployee = employeeRepository.findById(id).
               orElseThrow(() -> new RuntimeException("Id not foumd"));
       if (Objects.nonNull(employee.getAddress()) && !"".equalsIgnoreCase(employee.getAddress())) {
           existingEmployee.setAddress(employee.getAddress());
       }
       return employeeRepository.save(existingEmployee);
   }

    @Override
    public List<Employee> getEmployeeByIdAndName(Long id, String name) {
                 List<Employee> optionalEmployee1=  employeeRepository.getEmployeeByIdAndName(id,name);
        return optionalEmployee1;
    }



   @Override
    public List<Employee> getEmployeeByName(String name) {
        List<Employee> tiktaktoe=employeeRepository.getEmployeeByName(name);

        return tiktaktoe;
       // return List.of();
    }



    @Override
    public Employee updateEmployeeName(Long id, Employee employee) {
                   Employee optionalEmployee2 = employeeRepository.findById(id).
                           orElseThrow(() -> new RuntimeException("Id not foumd"));
                   if(Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName()))
                   {
                       optionalEmployee2.setName(employee.getName());
                   }
        return employeeRepository.save(optionalEmployee2);
    }

    @Override
    public Employee getEmployeeByAddress(String address) {
        return employeeRepository.getEmployeeByAddress(address)
                    ;

    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }


}
