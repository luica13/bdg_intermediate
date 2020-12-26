package com.bdg.dao;

import com.bdg.models.Employee;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM employee";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM employee where employee_id = ?";

    private Connection connection;

    public EmployeeDaoJdbcImpl(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Employee> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<Employee> find(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String birthdate = resultSet.getString("birthDate");
                String townFrom = resultSet.getString("townFrom");

                return Optional.of(new Employee(id, firstName, lastName, LocalDate.parse(birthdate), townFrom));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Employee> findAll() {
        try {
            List<Employee> employees = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Long id = resultSet.getLong("employee_id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String birthDate = resultSet.getString("birthDate");
                String townFrom = resultSet.getString("townFrom");

                Employee employee = new Employee(id, firstName, lastName, LocalDate.parse(birthDate), townFrom);
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            throw new IllegalStateException("Exception from findAll() methods!" + e);
        }
    }
}
