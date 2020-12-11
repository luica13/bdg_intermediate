package COM;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

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

    public static Trip getById(long id)
    {
        return Common.getById(Trip.class,id);
    }

    public static Set<Trip> getAll()
    {
        return Common.getAll(Trip.class,"trip" );
    }

    public static Trip save(Trip trip)
    {
        return Common.save(trip);
    }

    public static Trip update(Trip trip)
    {
        return Common.update(trip);
    }

    public static void delete(long id)
    {
        Common.delete(Trip.class, id);
    }

    public static List<Trip> getTripsFrom(String city)
    {
        EntityManager em = HibernateUtil.getEntityManager();
        List<Trip> trips = em.createQuery("SELECT c FROM Trip c INNER JOIN Address ON Trip.townFrom = Address.city where Address.city = :city")
                .setParameter("city", city)
                .getResultList();
        return trips;
    }

    public static List<Trip> getTripsTo(String city)
    {
        EntityManager em = HibernateUtil.getEntityManager();
        List<Trip> trips = em.createQuery("SELECT c FROM Trip c INNER JOIN Address ON Trip.townToo = Address.city where Address.city = :city")
                .setParameter("city", city)
                .getResultList();
        return trips;
    }
}
