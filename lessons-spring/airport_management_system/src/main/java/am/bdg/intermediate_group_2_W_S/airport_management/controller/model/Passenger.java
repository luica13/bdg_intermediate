package am.bdg.intermediate_group_2_W_S.airport_management.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@Data
public class Passenger {

    private long id;

    @NotNull
    @Size(min = 3, max = 100, message = "name length must be between 3 and 100")
    private String name;

    @NotNull
    @Size(max = 150)
    @Pattern(regexp = "^+(\\d){1,3}(\\d){6,100}", message = "phone number must be started with +" +
            " after this country code between 1 and 3 digits," +
            " and totally length must be less than 100")
    private String phone;

    @NotNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Address address;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Trip> trips;

    public void addTrip(Trip trip) {
        trips.add(trip);
        trip.getPassengers().add(this);
    }

    public void removeTrip(Trip trip) {
        trips.remove(trip);
        trip.getPassengers().remove(this);
    }
}
