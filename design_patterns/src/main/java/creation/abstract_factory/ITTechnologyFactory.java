package creation.abstract_factory;

import creation.abstract_factory.computers.Computer;
import creation.abstract_factory.phones.Phone;
import creation.abstract_factory.tv.TV;

public interface ITTechnologyFactory {
    Computer createComputer();

    Phone createPhone();

    TV createTV();
}
