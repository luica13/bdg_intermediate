import java.time.LocalTime;

public class Trip {
    private long id;
    private Company company;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private String townFrom;
    private String townTo;

    public Trip(Company company, LocalTime timeIn, LocalTime timeOut, String townFrom, String townTo) {
        this.company = company;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townFrom= townFrom;
        this.townTo = townTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public String getFromTown() {
        return townFrom;
    }

    public void setFromTown(String townFrom) {
        this.townFrom = townFrom;
    }

    public String getToTown() {
        return townTo;
    }

    public void setToTown(String townTo) {
        this.townTo = townTo;
    }
}