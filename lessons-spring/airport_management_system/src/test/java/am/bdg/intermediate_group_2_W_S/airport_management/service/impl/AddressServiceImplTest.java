package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.service.AddressService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.AddressDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AirportManagementSystemApp.class})
class AddressServiceImplTest {

    private final AddressService addressService;

    @Autowired
    AddressServiceImplTest(AddressService addressService) {
        this.addressService = addressService;
    }

    @Test
    void get() {
        AddressDto addressDto = addressService.get(7L);
        assertNotNull(addressDto);
        assertEquals(7, addressDto.getId());
    }

    @Test
    void getAll() {
        Set<AddressDto> all = addressService.getAll();
        assertFalse(all.isEmpty());
    }

    @Test
    void getCertainCrowd() {
        List<AddressDto> certainCrowd = addressService.getCertainCrowd(30, 5, "city", "country");
        assertEquals(30, certainCrowd.size());
    }

    @Test
    void create() {
        AddressDto addressDto = addressService.create(new AddressDto(0, "England", "Birmingham", null));
        assertNotNull(addressDto);
        assertEquals("England", addressDto.getCountry());
    }

    @Test
    void edit() {
        AddressDto addressDto = addressService.get(13L);
        assertNotNull(addressDto);
        addressDto.setCity("Gyumri");
        addressService.edit(addressDto);
        addressDto = addressService.get(13L);
        assertNotNull(addressDto);
        assertEquals("Gyumri", addressDto.getCity());
    }

    @Test
    void remove() {
        AddressDto address = addressService.get(77L);
        assertNotNull(address);

        addressService.remove(address);

        assertThrows(EntityNotFoundException.class, () -> addressService.get(77L));
    }

    @Test
    void removeById() {
        AddressDto address = addressService.get(44L);
        assertNotNull(address);

        addressService.removeById(address.getId());

        assertThrows(EntityNotFoundException.class, () -> addressService.get(44L));
    }

    @Test
    void getAddressPassengers() {
        AddressDto address = addressService.get(25L);
        assertNotNull(address);

        Set<PassengerDto> addressPassengers = addressService.getAddressPassengers(address);
        addressPassengers.forEach(
                passenger -> assertEquals(25, passenger.getAddress().getId()));
    }
}
