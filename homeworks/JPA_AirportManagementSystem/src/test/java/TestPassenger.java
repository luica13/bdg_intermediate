import COM.Passenger;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class TestPassenger {
    @BeforeAll
    public static void beforeAll()
    {
        System.out.println("Passenger tests start");
    }

    @AfterAll
    public static void afterAll()
    {
        System.out.println("Passenger tests end");
    }

    @Test
    public void testGetById()
    {
        Passenger p2 = Passenger.getById(2);
        Assertions.assertEquals(p2.getName(),"Valod");
    }

}
