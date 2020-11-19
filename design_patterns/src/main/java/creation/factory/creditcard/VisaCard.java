package creation.factory.creditcard;

import creation.factory.CreditCard;
import creation.factory.CreditCardType;

public class VisaCard extends CreditCard {
    private double rate;

    public VisaCard(Double balance) {
        super(CreditCardType.VISA_CARD.getCardName(), balance);
        this.rate = 1.0;
    }

    protected Double getRate() {
        return rate;
    }
}
