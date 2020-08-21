package com.ganesh.api.service;

import com.ganesh.api.model.Employee;

import java.util.List;

public interface EmployeeService {
  Employee save(Employee employee);
  List<Employee> readAll();
  Employee read(Integer id);
  Integer delete(Integer id);
}
