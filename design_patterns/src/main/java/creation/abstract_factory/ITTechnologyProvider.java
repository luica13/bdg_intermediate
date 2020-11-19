package creation.abstract_factory;

import creation.abstract_factory.factories.AppleTechnologyFactory;
import creation.abstract_factory.factories.SamsungTechnologyFactory;

import java.util.NoSuchElementException;

public class ITTechnologyProvider {
    public static ITTechnologyFactory getFactory(TechnologyProvider provider) {
        switch (provider) {
            case APPLE:
                return new AppleTechnologyFactory();
            case SAMSUNG:
                return new SamsungTechnologyFactory();
            default:
                throw new NoSuchElementException("No such Provider");
        }
    }
}
