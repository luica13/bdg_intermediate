package creation.abstract_factory.factories;

import creation.abstract_factory.ITTechnologyFactory;
import creation.abstract_factory.computers.Computer;
import creation.abstract_factory.computers.SamsungLaptop;
import creation.abstract_factory.phones.GalaxySmartPhone;
import creation.abstract_factory.phones.Phone;
import creation.abstract_factory.tv.SamsungTV;
import creation.abstract_factory.tv.TV;

public class SamsungTechnologyFactory implements ITTechnologyFactory {
    @Override
    public Computer createComputer() {
        return new SamsungLaptop();
    }

    @Override
    public Phone createPhone() {
        return new GalaxySmartPhone();
    }

    @Override
    public TV createTV() {
        return new SamsungTV();
    }
}
