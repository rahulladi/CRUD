//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.crud.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public EmployeeRepository() {
    }

    public Employee saveEmployee(Employee employee) {
        this.dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getEmployee(String employeeId) {
        return (Employee)this.dynamoDBMapper.load(Employee.class, employeeId);
    }

    public Employee updateEmployee(Employee employee) {
        this.dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee deleteEmployee(String employeeId) {
        Employee employee = (Employee)this.dynamoDBMapper.load(Employee.class, employeeId);
        this.dynamoDBMapper.delete(employee);
        return employee;
    }
}
