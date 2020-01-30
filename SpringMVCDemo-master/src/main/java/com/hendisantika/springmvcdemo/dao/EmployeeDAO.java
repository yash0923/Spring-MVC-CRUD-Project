package com.hendisantika.springmvcdemo.dao;

import com.hendisantika.springmvcdemo.entity.Employee;

import java.util.List;

/**
 * Created in Eclipse IDE.
 * Project :SpringMVCDemo-master
 * User: yash
 * Date: 18/01/2020
 */

public interface EmployeeDAO {
    void saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

    List<Employee> getAllEmployees();
}
