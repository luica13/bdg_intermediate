package creation.abstract_factory;

import creation.abstract_factory.computers.Computer;
import creation.abstract_factory.computers.MacBook;
import creation.abstract_factory.computers.SamsungLaptop;
import creation.abstract_factory.factories.AppleTechnologyFactory;
import creation.abstract_factory.factories.SamsungTechnologyFactory;
import creation.abstract_factory.phones.GalaxySmartPhone;
import creation.abstract_factory.phones.IPhone;
import creation.abstract_factory.phones.Phone;
import creation.abstract_factory.tv.AppleTV;
import creation.abstract_factory.tv.SamsungTV;
import creation.abstract_factory.tv.TV;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestITTechnologyAbstractFactory {
    ITTechnologyFactory factory;

    @Test
    void testAppleFactoryCreation() {
        factory = ITTechnologyProvider.getFactory(TechnologyProvider.APPLE);
        Assertions.assertTrue(factory instanceof AppleTechnologyFactory);
    }

    @Test
    void testSamsungFactoryCreation() {
        factory = ITTechnologyProvider.getFactory(TechnologyProvider.SAMSUNG);
        Assertions.assertTrue(factory instanceof SamsungTechnologyFactory);
    }

    @Nested
    class TestAppleTechnology {

        @BeforeEach
        void setUp() {
            factory = ITTechnologyProvider.getFactory(TechnologyProvider.APPLE);
        }

        @Test
        void testAppleComputerCreation() {
            Computer macBook = factory.createComputer();
            Assertions.assertTrue(macBook instanceof MacBook);
        }

        @Test
        void testApplePhoneCreation() {
            Phone phone = factory.createPhone();
            Assertions.assertTrue(phone instanceof IPhone);
        }

        @Test
        void testAppleTVCreation() {
            TV appleTV = factory.createTV();
            Assertions.assertTrue(appleTV instanceof AppleTV);
        }
    }

    @Nested
    class TestSamsungTechnology {

        @BeforeEach
        void setUp() {
            factory = ITTechnologyProvider.getFactory(TechnologyProvider.SAMSUNG);
        }

        @Test
        void testSamsungComputerCreation() {
            Computer laptop = factory.createComputer();
            Assertions.assertTrue(laptop instanceof SamsungLaptop);
        }

        @Test
        void testSamsungPhoneCreation() {
            Phone smartPhone = factory.createPhone();
            Assertions.assertTrue(smartPhone instanceof GalaxySmartPhone);
        }

        @Test
        void testSamsungTVCreation() {
            TV samsungTV = factory.createTV();
            Assertions.assertTrue(samsungTV instanceof SamsungTV);
        }
    }


}
