package creation.factory;

import creation.factory.creditcard.ArcaCard;
import creation.factory.creditcard.MasterCard;
import creation.factory.creditcard.VisaCard;

import java.util.NoSuchElementException;

public class CreditCardFactory {

    private CreditCardFactory() {
    }

    public static CreditCard getCreditCard(CreditCardType type, Double initialBalance) {
        switch (type) {
            case ARCA_CARD:
                return new ArcaCard(initialBalance);
            case VISA_CARD:
                return new VisaCard(initialBalance);
            case MASTER_CARD:
                return new MasterCard(initialBalance);
            default:
                throw new NoSuchElementException(String.format("Credit card with name %s does not supported", type));
        }
    }
}
