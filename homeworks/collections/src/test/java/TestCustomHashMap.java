//package main.java;



import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Test;

public class TestCustomHashMap {
    @BeforeAll
    public static void beforAll()
    {
        System.out.println("Tests start");
    }

    @AfterAll
    public static void afterAll()
    {
        System.out.println("Tests end");
    }

    @Test
    public void testHash() {
        int actual = CustomHashMap.hash(null);
        //Assertions.assertEquals(0,actual,"hash for NULL must be 0");
        Assertions.assertEquals(0,actual,"for Null hash is 0");
        //Assertions.a
    }


    @Test
    void testPut() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        Integer retVal1 = hashMap.put("key",41);
        Assertions.assertEquals(null,retVal1);
        Integer retVal2 = hashMap.put("key", 42);
        Assertions.assertEquals(41,retVal2);
    }

    @Test
    void testGetNode() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        Integer retVal1 = hashMap.put("key",41);
        CustomHashMap.Node node1 = hashMap.getNode("key1");
        CustomHashMap.Node node2 = hashMap.getNode("key");
        Assertions.assertEquals(null,retVal1);

        Assertions.assertEquals("key",node2.key);
        Assertions.assertEquals(41,node2.value);
    }

    @Test
    void testContains() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        Integer retVal1 = hashMap.put("key",41);

        Assertions.assertTrue(hashMap.contains("key"));

        Assertions.assertFalse(hashMap.contains("anotherKey"));
    }

    @Test
    void testPosition() {
        Random rand = new Random();
        int random =rand.nextInt();
        int position = -1;
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        try {
            Method method = CustomHashMap.class.getDeclaredMethod("position", int.class);
            method.setAccessible(true);
            position = (int)method.invoke(hashMap,random);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        Assertions.assertTrue(position>=0);
        Assertions.assertTrue(position<=hashMap.capacity);
    }
}
