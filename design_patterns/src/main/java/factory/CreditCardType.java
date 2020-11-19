package factory;

public enum CreditCardType {
    MASTER_CARD("Master"),
    ARCA_CARD("Arca"),
    VISA_CARD("Visa");

    private String cardName;

    public String getCardName() {
        return cardName;
    }

    CreditCardType(String cardName) {
        this.cardName = cardName;
    }
}
