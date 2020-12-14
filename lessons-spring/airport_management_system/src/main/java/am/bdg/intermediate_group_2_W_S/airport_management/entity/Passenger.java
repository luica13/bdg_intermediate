package am.bdg.intermediate_group_2_W_S.airport_management.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, nullable = false, length = 150)
    private String phone;

    @ManyToOne
    private Address address;

    @ManyToMany(mappedBy = "passengers", fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.REMOVE,
                    CascadeType.PERSIST
            })
    Set<Trip> trips;

    public Passenger(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
        trip.getPassengers().add(this);
    }

    public void removeTrip(Trip trip) {
        trips.remove(trip);
        trip.getPassengers().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id &&
                Objects.equals(name, passenger.name) &&
                Objects.equals(phone, passenger.phone) &&
                Objects.equals(address, passenger.address);
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
                .add("address=" + address)
                .toString();
    }
}
