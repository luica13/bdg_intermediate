package com.bdg.dao;

import com.bdg.models.Employee;

import java.util.List;

public interface EmployeeDao extends CrudDao<Employee> {
    List<Employee> findAllByFirstName(String firstName);
}
