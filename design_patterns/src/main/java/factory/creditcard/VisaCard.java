package factory.creditcard;

import factory.CreditCard;
import factory.CreditCardType;

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
