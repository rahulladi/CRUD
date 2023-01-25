
package com.example.crud.service;
import com.example.crud.entity.Admin;
import com.example.crud.entity.Employee;
import com.example.crud.entity.EmployeeDTO;
import com.example.crud.entity.EmployeeMapper;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService() {
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        this.employeeRepository.saveEmployee(employee);
        employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
        return employeeDTO;
    }

    public EmployeeDTO getEmployee(String employeeId) {
        EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;
        Employee employee = this.employeeRepository.getEmployee(employeeId);
        if (ObjectUtils.isEmpty(employee)) {
            throw new RuntimeException("Enter a valid userId");
        } else {
            EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
            return employeeDTO;
        }
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;
        Employee employee = this.employeeRepository.getEmployee(employeeDTO.getEmployeeId());
        if (ObjectUtils.isEmpty(employee)) {
            throw new RuntimeException("Enter a valid user details");
        } else {
            employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
            employee = this.employeeRepository.updateEmployee(employee);
            employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
            return employeeDTO;
        }
    }

    public EmployeeDTO deleteEmployee(String adminId, String employeeId) {
        Employee admin = this.employeeRepository.getEmployee(adminId);
        if (ObjectUtils.isEmpty(admin)) {
            throw new RuntimeException("Admin Id is invalid");
        } else if (admin.getAdmin() == Admin.NO) {
            throw new RuntimeException("You dont have admin access");
        } else {
            EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;
            Employee employee = this.employeeRepository.deleteEmployee(employeeId);
            if (ObjectUtils.isEmpty(employee)) {
                throw new RuntimeException("Enter a valid userId");
            } else {
                EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
                return employeeDTO;
            }
        }
    }
}
