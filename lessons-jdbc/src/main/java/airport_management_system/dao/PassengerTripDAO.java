package airport_management_system.dao;

import java.util.List;

public interface PassengerTripDAO {
    boolean save(long passengerId, long tripId);

    boolean delete(long passengerId, long tripId);

    void saveAll(List<String> passengersTrips);
}
