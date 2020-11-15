import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomArrayListTest {

    private static CustomArrayList customArrayList;
    private int size;

    @BeforeClass
    public static void setup(){
        customArrayList = new CustomArrayList();
    }

    @Test
    public void sizeShouldBeZeroWhenListIsEmpty(){
        size = customArrayList.getSize();
        Assert.assertEquals(0, size);
    }

    @Test
    public void sizeShouldIncreaseWhenAddElement(){
        customArrayList.add(1);
        customArrayList.add(3);
        size = customArrayList.getSize();
        Assert.assertEquals(2, size);
    }

    @Test
    public void sizeShouldDecreaseWhenRemoveElement(){
        customArrayList.remove(1);
        size = customArrayList.getSize();
        Assert.assertEquals(1, size);
    }

}
