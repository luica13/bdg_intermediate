package airportJPA;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_comp;

    @Column
    private int trip_no;

    public Trip(String id_comp, int trip_no, String town_from, String town_to, String time_in, String time_out) {
        this.id_comp = id_comp;
        this.trip_no = trip_no;
        this.town_from = town_from;
        this.town_to = town_to;
        this.time_in = time_in;
        this.time_out = time_out;
    }

    public Trip() {
    }

    public int getTrip_no() {
        return trip_no;
    }

    public void setTrip_no(int trip_no) {
        this.trip_no = trip_no;
    }

    public String getTown_from() {
        return town_from;
    }

    public void setTown_from(String town_from) {
        this.town_from = town_from;
    }

    public String getTown_to() {
        return town_to;
    }

    public void setTown_to(String town_to) {
        this.town_to = town_to;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    @Column
    private String town_from;

    @Column
    private String town_to;

    @Column
    private String time_in;

    @Column
    private String time_out;

    public void setId_comp(String id_comp) {
        this.id_comp = id_comp;
    }

    @Id
    public String getId_comp() {
        return id_comp;
    }
}
