package factory.creditcard;

import factory.CreditCard;
import factory.CreditCardType;

public class MasterCard extends CreditCard {
    private double rate;

    public MasterCard(Double balance) {
        super(CreditCardType.MASTER_CARD.getCardName(), balance);
        this.rate = 0.5;
    }

    protected Double getRate() {
        return rate;
    }
}
