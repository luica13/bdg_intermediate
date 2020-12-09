package com.bdg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comp_id;

    private String name;
    private LocalDate found_date;

    public Company() {
    }

    public Company(String name, LocalDate found_date) {
        this.name = name;
        this.found_date = found_date;
    }
}
