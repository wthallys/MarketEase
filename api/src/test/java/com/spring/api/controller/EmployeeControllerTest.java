package com.spring.api.controller;

import com.spring.api.model.Employee;
import com.spring.api.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> result = employeeController.getAllEmployees();

        verify(employeeService, times(1)).getAllEmployees();
        assertSame(employees, result);
    }

    @Test
    void testGetEmployeeById() {
        Long employeeId = 1L;
        Employee employee = new Employee();
        when(employeeService.getEmployeeById(employeeId)).thenReturn(employee);

        ResponseEntity<Employee> response = employeeController.getEmployeeById(employeeId);

        verify(employeeService, times(1)).getEmployeeById(employeeId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(employee, response.getBody());
    }

    @Test
    void testGetEmployeeByIdNotFound() {
        Long employeeId = 1L;
        when(employeeService.getEmployeeById(employeeId)).thenReturn(null);

        ResponseEntity<Employee> response = employeeController.getEmployeeById(employeeId);

        verify(employeeService, times(1)).getEmployeeById(employeeId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        when(employeeService.saveEmployee(employee)).thenReturn(employee);

        Employee result = employeeController.createEmployee(employee);

        verify(employeeService, times(1)).saveEmployee(employee);
        assertSame(employee, result);
    }

    @Test
    void testUpdateEmployee() {
        Long employeeId = 1L;
        Employee updatedEmployee = new Employee();
        when(employeeService.updateEmployee(employeeId, updatedEmployee)).thenReturn(updatedEmployee);

        ResponseEntity<Employee> response = employeeController.updateEmployee(employeeId, updatedEmployee);

        verify(employeeService, times(1)).updateEmployee(employeeId, updatedEmployee);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(updatedEmployee, response.getBody());
    }

    @Test
    void testUpdateEmployeeNotFound() {
        Long employeeId = 1L;
        Employee updatedEmployee = new Employee();
        when(employeeService.updateEmployee(employeeId, updatedEmployee)).thenReturn(null);

        ResponseEntity<Employee> response = employeeController.updateEmployee(employeeId, updatedEmployee);

        verify(employeeService, times(1)).updateEmployee(employeeId, updatedEmployee);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteEmployee() {
        Long employeeId = 1L;

        ResponseEntity<Void> response = employeeController.deleteEmployee(employeeId);

        verify(employeeService, times(1)).deleteEmployee(employeeId);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
