package airport_management_system.service;

public interface PassengerTripService {
    boolean create(long passengerId, long tripId);

    void loadPassengersTripsInfoFromFileAndCreateAll(String path);

    boolean remove(long passengerId, long tripId);
}