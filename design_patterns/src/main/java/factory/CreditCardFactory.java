package factory;

import factory.creditcard.ArcaCard;
import factory.creditcard.MasterCard;
import factory.creditcard.VisaCard;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CreditCardFactory {
    private static CreditCardFactory INSTANCE;

    private CreditCardFactory() {
    }

    public static CreditCardFactory getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (CreditCardFactory.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new CreditCardFactory();
                }
            }
        }
        return INSTANCE;
    }

    public CreditCard getCreditCard(CreditCardType type, Double initialBalance) {
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
