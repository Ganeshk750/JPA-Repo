package com.ganesh.api.service;

import com.ganesh.api.model.Employee;
import com.ganesh.api.model.MobileNumber;
import com.ganesh.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        for (MobileNumber mobileNumber: employee.getMobileNumbers()) {
            mobileNumber.setEmployee(employee);
        }
        employeeRepository.save(employee);
        return  employee;
    }

    @Override
    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee read(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Integer delete(Integer id) {
        employeeRepository.deleteById(id);
        return id;
    }


}
