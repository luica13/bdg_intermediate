package am.bdg.intermediate_group_2_W_S.airport_management.service.dto;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
public class AddressDto {

    private long id;

    @NotNull
    @Size(min = 2, max = 100, message = "country length can be between 2 and 100")
    private String country;

    @NotNull
    @Size(min = 2, max = 100, message = "city length can be between 2 and 100")
    private String city;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PassengerDto> passengers;
}
