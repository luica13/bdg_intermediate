package com.example.demo.DBsheets;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Trip {
        private long id;
        private Company company;
        private LocalDateTime timeIn;
        private LocalDateTime timeOut;
        private String fromCity;
        private String toCity;
        private Set<Passenger> passengers;

        private Trip(TripBuilder builder) {
            this.company = builder.company;
            this.timeIn = builder.timeIn;
            this.timeOut = builder.timeOut;
            this.fromCity = builder.fromCity;
            this.toCity = builder.toCity;
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

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }


        public LocalDateTime getTimeIn() {
            return timeIn;
        }

        public void setTimeIn(LocalDateTime timeIn) {
            this.timeIn = timeIn;
        }

        public LocalDateTime getTimeOut() {
            return timeOut;
        }

        public void setTimeOut(LocalDateTime timeOut) {
            this.timeOut = timeOut;
        }

        public String getFromCity() {
            return fromCity;
        }

        public void setFromCity(String fromCity) {
            this.fromCity = fromCity;
        }

        public String getToCity() {
            return toCity;
        }

        public void setToCity(String toCity) {
            this.toCity = toCity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trip trip = (Trip) o;
            return id == trip.id &&
                    Objects.equals(timeIn, trip.timeIn) &&
                    Objects.equals(timeOut, trip.timeOut) &&
                    Objects.equals(fromCity, trip.fromCity) &&
                    Objects.equals(toCity, trip.toCity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, timeIn, timeOut, fromCity, toCity);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Trip.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("company=" + company)
                    .add("timeIn=" + timeIn)
                    .add("timeOut=" + timeOut)
                    .add("fromCity='" + fromCity + "'")
                    .add("toCity='" + toCity + "'")
                    .toString();
        }

        public static class TripBuilder {

            private Company company;
            private LocalDateTime timeIn;
            private LocalDateTime timeOut;
            private String fromCity;
            private String toCity;

            public TripBuilder company(Company company) {
                this.company = company;
                return this;
            }

            public TripBuilder timeIn(LocalDateTime timeIn) {
                this.timeIn = timeIn;
                return this;
            }

            public TripBuilder timeOut(LocalDateTime timeOut) {
                this.timeOut = timeOut;
                return this;
            }

            public TripBuilder fromCity(String fromCity) {
                this.fromCity = fromCity;
                return this;
            }

            public TripBuilder toCity(String toCity) {
                this.toCity = toCity;
                return this;
            }

            public Trip build() {
                return new Trip(this);
            }
        }
    }