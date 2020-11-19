package creation.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCreditCardFactory {

    @Test
    public void testArcaCardCreation() {
        CreditCard arcaCard = CreditCardFactory.getCreditCard(CreditCardType.ARCA_CARD, 10000d);
        arcaCard.calculateBalance(1000d);
        Assertions.assertEquals(9000d, arcaCard.getBalance());
        Assertions.assertEquals(CreditCardType.ARCA_CARD.getCardName(), arcaCard.getName());
    }

    @Test
    public void testVisaCardCreation() {
        CreditCard visaCard = CreditCardFactory.getCreditCard(CreditCardType.VISA_CARD, 10000d);
        visaCard.calculateBalance(1000d);
        Assertions.assertEquals(8990d, visaCard.getBalance());
        Assertions.assertEquals(CreditCardType.VISA_CARD.getCardName(), visaCard.getName());
    }

    @Test
    public void testMasterCardCreation() {
        CreditCard masterCard = CreditCardFactory.getCreditCard(CreditCardType.MASTER_CARD, 10000d);
        masterCard.calculateBalance(1000d);
        Assertions.assertEquals(8995d, masterCard.getBalance());
        Assertions.assertEquals(CreditCardType.MASTER_CARD.getCardName(), masterCard.getName());
    }

}
