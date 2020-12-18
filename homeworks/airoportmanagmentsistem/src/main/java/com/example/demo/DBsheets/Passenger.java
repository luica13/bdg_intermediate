package com.example.demo.DBsheets;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Passenger {
        private long id;
        private String name;
        private String phone;
        private Adrress adrress;
        Set<Trip> trips;

        public Passenger(String name, String phone, Adrress adrress) {
            this.name = name;
            this.phone = phone;
            this.adrress = adrress;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Set<Trip> getTrips() {
            return trips;
        }

        public void setTrips(Set<Trip> trips) {
            this.trips = trips;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Adrress getAdrress() {
            return adrress;
        }

        public void setAdrress(Adrress adrress) {
            this.adrress = adrress;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Passenger passenger = (Passenger) o;
            return id == passenger.id &&
                    Objects.equals(name, passenger.name) &&
                    Objects.equals(phone, passenger.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, phone);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Passenger.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .add("phone='" + phone + "'")
                    .add("adrress=" + adrress)
                    .toString();
        }
    }
