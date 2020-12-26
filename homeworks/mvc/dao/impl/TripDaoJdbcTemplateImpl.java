package com.bdg.mvc.dao.impl;

import com.bdg.mvc.dao.TripDao;
import com.bdg.mvc.models.Trip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class TripDaoJdbcTemplateImpl implements TripDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public TripDaoJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Trip> findByPlane(String plane) {
        return null;
    }

    @Override
    public Optional<Trip> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Trip trip) {

    }

    @Override
    public void update(Trip trip) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Trip> findAll() {
        return null;
    }
}
