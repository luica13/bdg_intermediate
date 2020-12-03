package airport_management_system.service.impl;

import airport_management_system.dao.impl.PassengerTripDAOImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PassengerTripServiceImplTest {

    private static PassengerTripServiceImpl service;

    @BeforeAll
    static void setUp() {
        service = new PassengerTripServiceImpl(new PassengerTripDAOImpl());
    }

    @Test
    void create() {
        assertTrue(service.create(7, 9));
        assertFalse(service.create(0, 0));
    }

    @Test
    void remove() {
        if (service.create(2, 2))
            assertTrue(service.remove(2, 2));
        else Assertions.fail("failed create a trip");
    }
}
