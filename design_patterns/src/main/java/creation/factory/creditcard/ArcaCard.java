package creation.factory.creditcard;

import creation.factory.CreditCard;
import creation.factory.CreditCardType;

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
