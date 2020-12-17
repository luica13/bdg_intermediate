package am.bdg.intermediate_group_2_W_S.airport_management.controller.model;

import am.bdg.intermediate_group_2_W_S.airport_management.model.Trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Data
public class Company {

    private long id;

    @NotNull
    @Size(min = 3, message = "company name length should be grater than 3")
    private String name;

    @Past
    private LocalDate foundingDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Trip> trips;
}
