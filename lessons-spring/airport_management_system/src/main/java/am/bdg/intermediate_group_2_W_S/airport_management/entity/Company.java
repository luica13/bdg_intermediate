package am.bdg.intermediate_group_2_W_S.airport_management.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "founding_date", columnDefinition = "DATE", nullable = false)
    private LocalDate foundingDate;

    @OneToMany(mappedBy = "company",
            cascade = {CascadeType.REMOVE, CascadeType.REFRESH},
            orphanRemoval = true)
    private Set<Trip> trips;

    public Company(String name, LocalDate foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
        trip.setCompany(this);
    }

    public void removeTrip(Trip trip) {
        trips.remove(trip);
        trip.setCompany(null);
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
