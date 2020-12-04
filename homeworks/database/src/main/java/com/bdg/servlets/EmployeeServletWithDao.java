package com.bdg.servlets;

import com.bdg.dao.EmployeeDao;
import com.bdg.dao.EmployeeDaoJdbcTemplateImpl;
import com.bdg.models.Employee;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet("/employees")
public class EmployeeServletWithDao extends HttpServlet {
    private EmployeeDao employeeDao;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            dataSource.setUrl(dbUrl);
            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            dataSource.setDriverClassName(driverClassName);

            //employeeDao = new EmployeeDaoJdbcImpl(dataSource);
            employeeDao = new EmployeeDaoJdbcTemplateImpl(dataSource);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = null;
        if (request.getParameter("firstName") != null) {
            String firstName = request.getParameter("firstName");
            employees = employeeDao.findAllByFirstName(firstName);
        } else {
            employees = employeeDao.findAll();
        }
        request.setAttribute("employeesFromServer", employees);
        request.getServletContext().getRequestDispatcher("/jsp/employees.jsp").forward(request, response);
    }
}
