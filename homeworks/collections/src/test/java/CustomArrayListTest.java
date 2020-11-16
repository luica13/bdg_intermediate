import org.junit.*;

public class CustomArrayListTest {

    private static CustomArrayList customArrayList;
    private int size;

    @Before
    public  void setup(){
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
        customArrayList.add(5);
        customArrayList.add(4);
        customArrayList.remove(1);
        size = customArrayList.getSize();
        Assert.assertEquals(1, size);
    }

    @Test
    public void sizeShouldIncreaseWhenAddElementUsingIndex(){
        customArrayList.add(0, 77);
        size = customArrayList.getSize();
        Assert.assertEquals(1, size);
    }

    @Test
    public void getItemMethodShouldReturnRequiredItem(){
        customArrayList.add(1);
        customArrayList.add(2);
        Object i = customArrayList.getItem(0);
        Object i2 = customArrayList.getItem(1);
        Assert.assertEquals(1, i);
        Assert.assertEquals(2, i2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGiveExceptionWhenIndexLesserThen0(){
        customArrayList.add(-1, 4);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGiveExceptionWhenIndexGreaterThenSize(){
        customArrayList.add(0, 4);
        customArrayList.add(3,7);
    }

    @Test
    public void shouldUpdateCapacityWhenSizeLessThenDefaultCapacity(){
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        int capacity = customArrayList.getCapacity();
        Assert.assertEquals(16, capacity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGiveExceptionWhenCapacityLesserThen0(){
        CustomArrayList customArrayList = new CustomArrayList(-4);
    }
}
