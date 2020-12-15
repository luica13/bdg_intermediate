package com.bdg.mvc.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {
    private Long id;

    private String plane;
    private String town_from;
    private String town_to;
    private LocalDateTime time_out;
    private LocalDateTime time_in;

    private Passenger traveler;
}
