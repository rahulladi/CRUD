package com.example.crud.controller;

import com.example.crud.entity.Admin;
import com.example.crud.entity.EmployeeDTO;
import com.example.crud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@WebMvcTest({EmployeeController.class})
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    EmployeeDTO expectedEmployeeDTO;
    String sampleJsonInput;

    EmployeeControllerTest() {
        this.expectedEmployeeDTO = new EmployeeDTO("b5740b64-d573-45d5-b588-8443bb190b70", "Ramm", 100000, "USA", "iamraadhul@gmail.com", "Manager", Admin.NO);
        this.sampleJsonInput = "{\"employeeId\":\"b5740b64-d573-45d5-b588-8443bb190b70\",\"name\":\"Ramm\",\"pay\":100000,\"location\":\"USA\",\"email\":\"iamraadhul@gmail.com\",\"position\":\"Manager\",\"admin\":\"NO\"}";
    }

    @Test
    void saveEmployeeTest() throws Exception {
        Mockito.when(this.employeeService.saveEmployee((EmployeeDTO)Mockito.any(EmployeeDTO.class))).thenReturn(this.expectedEmployeeDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employees", new Object[0]).accept(new MediaType[]{MediaType.APPLICATION_JSON}).content(this.sampleJsonInput).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        AssertionErrors.assertEquals("Save method is not as expected", this.sampleJsonInput, result.getResponse().getContentAsString());
    }

    @Test
    void getEmployeeTest() throws Exception {
        Mockito.when(this.employeeService.getEmployee(Mockito.anyString())).thenReturn(this.expectedEmployeeDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/{employeeId}", new Object[]{new String("b5740b64-d573-45d5-b588-8443bb190b70")}).accept(new MediaType[]{MediaType.APPLICATION_JSON});
        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        AssertionErrors.assertEquals("Get method is not as expected", this.sampleJsonInput, result.getResponse().getContentAsString());
    }

    @Test
    void updateEmployeeTest() throws Exception {
        Mockito.when(this.employeeService.updateEmployee((EmployeeDTO)Mockito.any(EmployeeDTO.class))).thenReturn(this.expectedEmployeeDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/employees", new Object[0]).accept(new MediaType[]{MediaType.APPLICATION_JSON}).content(this.sampleJsonInput).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        AssertionErrors.assertEquals("Update method is not as expected", this.sampleJsonInput, result.getResponse().getContentAsString());
    }

    @Test
    void deleteEmployeeTest() throws Exception {
        Mockito.when(this.employeeService.deleteEmployee(Mockito.anyString(), Mockito.anyString())).thenReturn(this.expectedEmployeeDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/employees/{employeeId}", new Object[]{new String("b5740b64-d573-45d5-b588-8443bb190b70")}).header("adminId", new Object[]{"AGKAGYTO214NDLH-35-GAGH"});
        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        AssertionErrors.assertEquals("Get method is not as expected", this.sampleJsonInput, result.getResponse().getContentAsString());
    }
}