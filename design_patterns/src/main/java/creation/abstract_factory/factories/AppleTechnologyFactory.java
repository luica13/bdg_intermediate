package creation.abstract_factory.factories;

import creation.abstract_factory.ITTechnologyFactory;
import creation.abstract_factory.computers.Computer;
import creation.abstract_factory.computers.MacBook;
import creation.abstract_factory.phones.IPhone;
import creation.abstract_factory.phones.Phone;
import creation.abstract_factory.tv.AppleTV;
import creation.abstract_factory.tv.TV;

public class AppleTechnologyFactory implements ITTechnologyFactory {
    @Override
    public Computer createComputer() {
        return new MacBook();
    }

    @Override
    public Phone createPhone() {
        return new IPhone();
    }

    @Override
    public TV createTV() {
        return new AppleTV();
    }
}
