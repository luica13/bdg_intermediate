package factory.creditcard;

import factory.CreditCard;
import factory.CreditCardType;

public class ArcaCard extends CreditCard {
    private double rate;

    public ArcaCard(Double balance) {
        super(CreditCardType.ARCA_CARD.getCardName(), balance);
        this.rate = 0.0;
    }

    protected Double getRate() {
        return rate;
    }
}
