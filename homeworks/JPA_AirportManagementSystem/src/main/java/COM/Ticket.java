package COM;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long number;
    @ManyToOne
    private Trip trip;
    @ManyToOne
    private Passenger passenger;

    public Ticket() {
    }

    public Ticket(Trip trip, Passenger passenger) {
        this.trip = trip;
        this.passenger = passenger;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
