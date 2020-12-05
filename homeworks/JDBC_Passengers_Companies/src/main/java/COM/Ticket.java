package COM;

public class Ticket {
    private Trip trip;
    private Passenger passenger;

    public Ticket(Trip trip, Passenger passenger) {
        this.trip = trip;
        this.passenger = passenger;
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
