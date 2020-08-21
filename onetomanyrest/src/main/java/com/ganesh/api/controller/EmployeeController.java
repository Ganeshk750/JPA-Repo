package com.ganesh.api.controller;

import com.ganesh.api.model.Employee;
import com.ganesh.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping()
    public List<Employee> readAlls(){
        return employeeService.readAll();
    }
    @GetMapping("/{id}")
    public Employee read(@PathVariable Integer id){
        return employeeService.read(id);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return employeeService.delete(id);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
}
