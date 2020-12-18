package com.example.demo.DBsheets;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Adrress {
        private long id;
        private String country;
        private String city;
        private Set<Passenger> passengers;

        public Adrress(String country, String city) {
            this.country = country;
            this.city = city;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Set<Passenger> getPassengers() {
            return passengers;
        }

        public void setPassengers(Set<Passenger> passengers) {
            this.passengers = passengers;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Adrress adrress = (Adrress) o;
            return id == adrress.id &&
                    Objects.equals(country, adrress.country) &&
                    Objects.equals(city, adrress.city) &&
                    Objects.equals(passengers, adrress.passengers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, country, city);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Adrress.class.getSimpleName() + "[", "]")
                    .add("country='" + country + "'")
                    .add("city='" + city + "'")
                    .toString();
        }
}
