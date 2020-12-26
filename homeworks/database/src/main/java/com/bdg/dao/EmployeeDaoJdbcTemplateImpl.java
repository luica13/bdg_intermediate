package com.bdg.dao;

import com.bdg.models.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoJdbcTemplateImpl implements EmployeeDao {
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate parameterTemplate;

    public EmployeeDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.parameterTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Employee> employeeRowMapper =
            (resultSet, i) -> {
                return new Employee(
                        resultSet.getLong("employee_id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        LocalDate.parse(resultSet.getString("birthDate")),
                        resultSet.getString("townFrom"));
            };

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM employee";

    //language=SQL
    private final String SQL_SELECT_BY_FIRST_NAME = "SELECT * FROM employee WHERE firstName = ?";

    @Override
    public List<Employee> findAllByFirstName(String firstName) {
        return template.query(SQL_SELECT_BY_FIRST_NAME, employeeRowMapper, firstName);
    }

    @Override
    public Optional<Employee> find(Long id) {
        return Optional.empty();
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
        return template.query(SQL_SELECT_ALL, employeeRowMapper);
    }
}
