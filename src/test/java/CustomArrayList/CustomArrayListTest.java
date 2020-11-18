package CustomArrayList;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomArrayListTest {

    private static CustomArrayList customArrayList;
    private int size;

    @Before
    public  void setup(){
        customArrayList = new CustomArrayList();
    }

    @Test
    public void testSize() {
        size = customArrayList.size();
        Assert.assertEquals(0,size);
    }

    @Test
    public void testAdd() {
        customArrayList.add("banana");
        customArrayList.add("apple");
        size = customArrayList.size();
        Assert.assertEquals(2,size);

    }

    @Test
    public void testDelete() {
        customArrayList.add("mango");
        customArrayList.add("guava");
        customArrayList.delete(1);
        size = customArrayList.size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void testGet() {
        customArrayList.add(1);
        customArrayList.add(2);
        Object ob1= customArrayList.get(0);
        Object ob2 = customArrayList.get(1);
        Assert.assertEquals(1, ob1);
        Assert.assertEquals(2, ob2);
    }

}