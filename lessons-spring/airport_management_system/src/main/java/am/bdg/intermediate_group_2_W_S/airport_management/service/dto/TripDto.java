package am.bdg.intermediate_group_2_W_S.airport_management.service.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;



@Data
@Builder
@AllArgsConstructor
public class TripDto {

    private long id;

    @NotNull
    private CompanyDto company;

    @NotNull
    @PastOrPresent
    @Pattern(regexp = "^(\\d){4}-(\\d){2}-(\\d){2} (\\d:){2}(\\d){2}", message = "date_time format must be 'yyyy-MM-dd hh:mm:ss'")
    private LocalDateTime timeIn;

    @NotNull
    @PastOrPresent
    @Pattern(regexp = "^(\\d){4}-(\\d){2}-(\\d){2} (\\d:){2}(\\d){2}", message = "date_time format must be 'yyyy-MM-dd hh:mm:ss'")
    private LocalDateTime timeOut;

    @NotNull
    @Size(min = 2, max = 100, message = "city length can be between 2 and 100")
    private String fromCity;

    @NotNull
    @Size(min = 2, max = 100, message = "city length can be between 2 and 100")
    private String toCity;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PassengerDto> passengers;
}
