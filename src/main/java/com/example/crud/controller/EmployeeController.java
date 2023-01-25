//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.crud.controller;

import com.example.crud.entity.EmployeeDTO;
import com.example.crud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public EmployeeController() {
    }

    @PostMapping({"/employees"})
    public EmployeeDTO saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return this.employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping({"/employees/{employeeId}"})
    public EmployeeDTO getEmployee(@PathVariable("employeeId") String employeeId) {
        return this.employeeService.getEmployee(employeeId);
    }

    @PatchMapping({"/employees"})
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return this.employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping({"/employees/{employeeId}"})
    public EmployeeDTO deleteEmployee(@PathVariable("employeeId") String employeeId, @RequestHeader("adminId") String adminId) {
        try {
            EmployeeDTO employeeDTO = this.employeeService.deleteEmployee(adminId, employeeId);
            return employeeDTO;
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }
}
