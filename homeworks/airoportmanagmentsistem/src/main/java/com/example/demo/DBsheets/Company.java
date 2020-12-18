package com.example.demo.DBsheets;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Company {
        private long id;
        private String name;
        private LocalDate foundingDate;
        private Set<Trip> trips;

        public Company(String name, LocalDate foundingDate) {
            this.name = name;
            this.foundingDate = foundingDate;
        }

        public Set<Trip> getTrips() {
            return trips;
        }

        public void setTrips(Set<Trip> trips) {
            this.trips = trips;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getFoundingDate() {
            return foundingDate;
        }

        public void setFoundingDate(LocalDate foundingDate) {
            this.foundingDate = foundingDate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Company company = (Company) o;
            return id == company.id &&
                    Objects.equals(name, company.name) &&
                    Objects.equals(foundingDate, company.foundingDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, foundingDate);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Company.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .add("foundingDate=" + foundingDate)
                    .toString();
        }
    }

