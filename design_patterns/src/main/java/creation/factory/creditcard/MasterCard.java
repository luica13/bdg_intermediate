package creation.factory.creditcard;

import creation.factory.CreditCard;
import creation.factory.CreditCardType;

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
