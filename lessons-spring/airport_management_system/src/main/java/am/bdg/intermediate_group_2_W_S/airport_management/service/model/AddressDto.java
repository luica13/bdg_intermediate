package am.bdg.intermediate_group_2_W_S.airport_management.service.model;

import am.bdg.intermediate_group_2_W_S.airport_management.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@Data
public class AddressDto {

    private long id;

    private String country;

    private String city;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Passenger> passengers;
}
