package java;

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
        size = customArrayList.size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void sizeShouldIncreaseWhenAddElement(){
        customArrayList.add(1);
        customArrayList.add(3);
        size = customArrayList.size();
        Assert.assertEquals(2, size);
    }


    @Test
    public void sizeShouldBeZero(){
        customArrayList.add(1);
        customArrayList.add(3);
        customArrayList.add(5);
        customArrayList.add(6);
        customArrayList.clear();
        size = customArrayList.size();
        Assert.assertEquals(0,size);

    }

}

