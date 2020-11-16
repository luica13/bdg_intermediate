package main.java;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    private static ArrayListCustom<Integer> customArrayList;
    private static int size;
    @BeforeAll
    public static void init(){
        customArrayList=new ArrayListCustom<>();
    }
    @Test
    @DisplayName("Testing the add method")
    public void addTest(){
        customArrayList.add(1);
        customArrayList.add(5);
        customArrayList.add(9);
        size=customArrayList.getSize();
        Assertions.assertEquals(3,size,"Size will be 3,as we added 3 elements");
    }
    @Test
    @DisplayName("Testing the getSize method")
    public void sizeTestEmpty(){
        size=customArrayList.getSize();
        assertEquals(0,size,"Size should be 0 as we didn't add any element");
    }
    @Test
    @DisplayName("Testing the remove method")
        public void removeSizeTest(){
        customArrayList.add(4);
        customArrayList.add(5);
        customArrayList.remove(0);
        size=customArrayList.getSize();
            assertEquals(1,size,"The result will be 1 as we deleted 1 element");
        }
    @Test
    @DisplayName("Testing the get method")
    public void getTest(){
        customArrayList.add(4);
        customArrayList.add(10);
        int x=customArrayList.get(1);
        assertEquals(10,x,"The result will be 10,as 10 is at index 1");
    }
}
