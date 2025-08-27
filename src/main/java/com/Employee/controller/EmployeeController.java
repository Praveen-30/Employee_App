package com.Employee.controller;

import com.Employee.entity.Employee;
import com.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/first")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {     Employee emp=employeeService.saveEmployee(employee);
        return ResponseEntity.ok(emp);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
    {
       return employeeService.updateEmployee(id,employee);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
// This one and above gives same output just
    @GetMapping("/getByRequestParam")
    public Employee getEmployeeByIdRP(@RequestParam Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Long id)
    {    employeeService.deleteEmployeeById(id);
        return "Deleted Succesfully!!Id number:"+""+id;
    }
//Patchmapping using sending address as Pathvariable
  @PatchMapping("/patch/{id}")
    public Employee updateEmployeeaddress(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployeeaddress(id,employee);
  }

  @GetMapping("/get1/{id}/{name}")
    public  List<Employee> getEmployeeByIdAndName(@PathVariable Long id ,@PathVariable String name){

        return employeeService.getEmployeeByIdAndName(id, name);
  }
    @GetMapping("/get2/{name}")
    public  List<Employee> getEmployeeByName( @PathVariable String name){

        return employeeService.getEmployeeByName(name);
    }
  @PatchMapping("patch2/{id}")
    public ResponseEntity<Employee> updateEmployeeName(@PathVariable Long id ,@RequestBody Employee employee)
  {
      Employee employeeName=employeeService.updateEmployeeName(id, employee);
      return new ResponseEntity<Employee>(employeeName, HttpStatus.CREATED);
  }
  @GetMapping("add/{address}")
  public ResponseEntity<Employee> getEmployeeByAddress(@PathVariable String address) {

          Employee epg = employeeService.getEmployeeByAddress(address);
          return ResponseEntity.ok(epg);

    }
    // With ResponseEntity String is reflecting in output
    @DeleteMapping("deleteAll")
public ResponseEntity<String> deleteAll()
{
    employeeService.deleteAll();
    return new ResponseEntity<>("Successfully Deleted all",HttpStatus.NO_CONTENT);
}


}
