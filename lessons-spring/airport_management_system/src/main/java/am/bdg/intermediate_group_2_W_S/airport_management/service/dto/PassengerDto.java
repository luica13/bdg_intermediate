package am.bdg.intermediate_group_2_W_S.airport_management.service.dto;

import lombok.*;

import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class PassengerDto {

    private long id;

    @Size(min = 3, max = 100)
    private String name;

    @Size(max = 150)
    private String phone;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AddressDto address;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<TripDto> trips;
}
