package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.model.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.model.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.service.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AirportManagementSystemApp.class})
class AddressServiceImplTest {

    private final AddressService addressService;

    @Autowired
    AddressServiceImplTest(AddressService addressService) {
        this.addressService = addressService;
    }

//    @Test
//    void get() {
//        Optional<Address> optionalAddress = addressService.get(7L);
//        optionalAddress.ifPresentOrElse(
//                address -> assertEquals(7, address.getId()),
//                Assertions::fail);
//    }
//
//    @Test
//    void getAll() {
//        Set<Address> all = addressService.getAll();
//        assertFalse(all.isEmpty());
//    }
//
//    @Test
//    void getCertainCrowd() {
//        List<Address> certainCrowd = addressService.getCertainCrowd(30, 5, "city", "country");
//        assertEquals(30, certainCrowd.size());
//    }
//
//    @Test
//    void create() {
//        Optional<Address> optionalAddress = addressService.create(new Address("England", "Birmingham"));
//        optionalAddress.ifPresentOrElse(address -> {
//            address = addressService.get(address.getId()).orElse(new Address());
//            assertEquals("England", address.getCountry());
//        }, Assertions::fail);
//    }
//
//    @Test
//    void edit() {
//        Optional<Address> optionalAddress = addressService.get(13L);
//        optionalAddress.ifPresent(address -> {
//            address.setCity("Gyumri");
//            addressService.edit(address);
//        });
//        optionalAddress = addressService.get(13L);
//        optionalAddress.ifPresentOrElse(
//                address -> assertEquals("Gyumri", address.getCity()),
//                Assertions::fail);
//    }
//
//    @Test
//    void remove() {
//        Address address = addressService.get(66L).orElse(null);
//        assertNotNull(address);
//
//        addressService.remove(address);
//
//        address = addressService.get(66L).orElse(null);
//        assertNull(address);
//    }
//
//    @Test
//    void removeById() {
//        Address address = addressService.get(55L).orElse(null);
//        assertNotNull(address);
//
//        addressService.removeById(address.getId());
//
//        address = addressService.get(66L).orElse(null);
//        assertNull(address);
//    }
//
//    @Test
//    void getAddressPassengers() {
//        Address address = addressService.get(25L).orElse(null);
//        assertNotNull(address);
//
//        Set<Passenger> addressPassengers = addressService.getAddressPassengers(address);
//        addressPassengers.forEach(
//                passenger -> assertEquals(25, passenger.getAddress().getId()));
//    }
}
