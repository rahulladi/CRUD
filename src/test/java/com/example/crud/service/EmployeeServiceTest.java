package com.example.crud.service;

import com.example.crud.entity.Admin;
import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith({MockitoExtension.class})
class EmployeeServiceTest {
    @Autowired
    @InjectMocks
    EmployeeService employeeService;
    @Mock
    EmployeeRepository employeeRepository;
    Employee employee;
    Employee adminEmployee;

    EmployeeServiceTest() {
        this.employee = new Employee("b5740b64-d573-45d5-b588-8443bb190b70", "Ramm", 100000, "USA", "Ramm@gmail.com", "Intern", Admin.NO);
        this.adminEmployee = new Employee("b5740b64-vb5740b64b5740b64b5740b64", "Rohan", 100000, "USA", "Rohan@gmail.com", "Manager", Admin.YES);
    }

    @Test
    void saveEmployeeTest() {
        Mockito.when(this.employeeRepository.saveEmployee(this.employee)).thenReturn(this.employee);
        Assertions.assertEquals(this.employee, this.employeeRepository.saveEmployee(this.employee));
    }

    @Test
    void getEmployeeTest() {
        Mockito.when(this.employeeRepository.getEmployee(this.employee.getEmployeeId())).thenReturn(this.employee);
        Assertions.assertEquals(this.employee, this.employeeRepository.getEmployee(this.employee.getEmployeeId()));
    }

    @Test
    void updateEmployeeTest() {
        Mockito.when(this.employeeRepository.updateEmployee(this.employee)).thenReturn(this.employee);
        Assertions.assertEquals(this.employee, this.employeeRepository.updateEmployee(this.employee));
    }

    @Test
    void deleteEmployeeTest() {
        Mockito.when(this.employeeRepository.deleteEmployee(this.employee.getEmployeeId())).thenReturn(this.employee);
        Assertions.assertEquals(this.employee, this.employeeRepository.deleteEmployee(this.employee.getEmployeeId()));
    }

}