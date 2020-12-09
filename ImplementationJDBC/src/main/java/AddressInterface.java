import java.util.List;
import java.util.Set;

public interface AddressInterface {
    Address getById(long id);
    Address save(Address address);
    Address update(Address address);
    void delete(long addressId);
    List<Address> getAddressesFrom(String city);
    List<Address> getTripsTo(String city);
}
