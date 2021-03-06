package com.hendisantika.springmvcdemo.dao;

import com.hendisantika.springmvcdemo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created in Eclipse IDE.
 * Project : SpringMVCDemo-master
 * User: yash
 * Date: 18/01/2020
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);
    private JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Saving a new Employee
    public void saveEmployee(Employee employee) {
        String sql = "insert into Employee values(?,?,?,?)";
        LOGGER.info("DAO Called {} Save Employee", sql);
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getDept(), employee.getAge());
    }

    // Getting a particular Employee
    public Employee getEmployeeById(int id) {
        String sql = "select * from Employee where id=?";
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]
                {id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setDept(rs.getString(3));
                employee.setAge(rs.getInt(4));
                return employee;
            }
        });
        LOGGER.info("DAO Called {} getEmployeeById", sql);
        return employee;
    }

    // Getting all the Employees
    public List<Employee> getAllEmployees() {
        String sql = "select * from Employee";

        List<Employee> employeeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<Employee>();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setDept(rs.getString(3));
                    employee.setAge(rs.getInt(4));
                    list.add(employee);
                }
                return list;
            }

        });
        LOGGER.info("DAO Called {} getAllEmployees", sql);
        return employeeList;
    }

    // Updating a particular Employee
    public void updateEmployee(Employee employee) {
        String sql = "update Employee set age =?, dept=?,name=? where id=?";
        LOGGER.info("DAO Called {} updateEmployee", sql);
        jdbcTemplate.update(sql, employee.getAge(), employee.getDept(), employee.getName(), employee.getId());
    }

    // Deletion of a particular Employee
    public void deleteEmployee(int id) {
        String sql = "delete FROM employee where id=?";
        LOGGER.info("DAO Called {} deleteEmployee", sql);
        jdbcTemplate.update(sql, id);
    }
}
