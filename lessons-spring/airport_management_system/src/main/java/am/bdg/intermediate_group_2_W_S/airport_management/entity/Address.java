package am.bdg.intermediate_group_2_W_S.airport_management.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"country", "city"}))
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false, length = 100)
    private String city;

    @OneToMany(mappedBy = "address",
            cascade = {CascadeType.REMOVE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH},
            orphanRemoval = true)
    private Set<Passenger> passengers;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.setAddress(this);
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.setAddress(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                Objects.equals(country, address.country) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("country='" + country + "'")
                .add("city='" + city + "'")
                .toString();
    }
}

