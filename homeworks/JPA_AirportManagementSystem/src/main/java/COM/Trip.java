package COM;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tripNumber;
    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private Company company;
    private ZonedDateTime timeIn;
    private ZonedDateTime timeOut;
    @ManyToOne
    private Address townToo;
    @ManyToOne
    private Address townFrom;

    public Trip() {
    }

    public Trip(long tripNumber, Company company, ZonedDateTime timeIn, ZonedDateTime timeOut, Address townToo, Address townFrom) {
        this.tripNumber = tripNumber;
        this.company = company;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townToo = townToo;
        this.townFrom = townFrom;
    }

    public long getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(long tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ZonedDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(ZonedDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public ZonedDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(ZonedDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public Address getTownToo() {
        return townToo;
    }

    public void setTownToo(Address townToo) {
        this.townToo = townToo;
    }

    public Address getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(Address townFrom) {
        this.townFrom = townFrom;
    }
}
