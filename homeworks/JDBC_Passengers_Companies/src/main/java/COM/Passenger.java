package COM;

public class Passenger {
    private  long id;
    private String name;
    private String passengerPhone;
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Passenger(String name, String passengerPhone, Address address) {
        this.name = name;
        this.passengerPhone = passengerPhone;
        this.address = address;
    }
}
