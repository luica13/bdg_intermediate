package com.bdg.mvc.dao.impl;

import com.bdg.mvc.dao.PassengerDao;
import com.bdg.mvc.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PassengerDaoJdbcTemplateImpl implements PassengerDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public PassengerDaoJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM passenger";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM passenger where passenger_id = ?";

    //language=SQL
    private final String SQL_INSERT_PASSENGER =
            "INSERT INTO passenger(city, country, name, phone)" +
                    " VALUES (:city, :country, :name, :phone)";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_FIRSTNAME
            = "SELECT * FROM passenger WHERE name = ?";

    private RowMapper<Passenger> passengerRowMapper
            = (resultSet, i) -> {
        return new Passenger(
                resultSet.getLong("passenger_id"),
                resultSet.getString("city"),
                resultSet.getString("country"),
                resultSet.getString("name"),
                resultSet.getString("phone"));
    };

    @Override
    public List<Passenger> findAllByFirstName(String firstName) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_FIRSTNAME, passengerRowMapper, firstName);
    }

    @Override
    public Passenger findTravelerByCity(String city) {
        return null;
    }

    @Override
    public Optional<Passenger> find(Long id) {
        List<Passenger> result = jdbcTemplate.query(SQL_SELECT_BY_ID, passengerRowMapper, id);
        if (result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(result.get(0));
    }

    @Override
    public void save(Passenger passenger) {
        Map<String, Object> params = new HashMap<>();
        params.put("city", passenger.getCity());
        params.put("country", passenger.getCountry());
        params.put("name", passenger.getName());
        params.put("phone", passenger.getPhone());
        namedJdbcTemplate.update(SQL_INSERT_PASSENGER, params);
    }

    @Override
    public void update(Passenger passenger) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Passenger> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, passengerRowMapper);
    }
}
