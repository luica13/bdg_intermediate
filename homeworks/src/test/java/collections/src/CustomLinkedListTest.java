package collections.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CustomLinkedListTest {
    CustomLinkedList<String> customLinkedList;
    List<String> inputs;

    @BeforeEach
    void setUp() {
        customLinkedList = new CustomLinkedList<>();
        inputs = Arrays.asList("Spring", "Summer", "Autumn", "Winter");
    }

    @Test
    void add() {
        String temp = "test";
        int size = customLinkedList.size();
        customLinkedList.add(temp);
        Assertions.assertTrue(customLinkedList.contains(temp));
        Assertions.assertEquals(size + 1, customLinkedList.size());
        Assertions.assertEquals(temp, customLinkedList.get(size));
    }


    @Test
    void addAll() {
        customLinkedList.addAll(inputs);
        Assertions.assertEquals(inputs.size(), customLinkedList.size());
    }

    @Nested
    class CustomLinkedListOtherMethods {
        String test;

        @BeforeEach
        void setUp() {
            test = "Winter";
            customLinkedList.addAll(inputs);
        }

        @Test
        void contains() {
            Assertions.assertTrue(customLinkedList.contains("Spring"));
        }

        @Test
        void toArray() {
            List<String> weather = Arrays.asList("Spring", "Summer", "Autumn", "Winter");
            Assertions.assertArrayEquals(weather.toArray(), customLinkedList.toArray());
        }

        @Test
        void remove() {
            int size = customLinkedList.size();
            Assertions.assertTrue(customLinkedList.contains(test));
            customLinkedList.remove(test);
            Assertions.assertEquals(size - 1, customLinkedList.size());
            Assertions.assertFalse(customLinkedList.contains(test));
        }

        @Test
        void clear() {
            int size = customLinkedList.size();
            customLinkedList.clear();
            Assertions.assertNotEquals(size, customLinkedList.size());
            Assertions.assertTrue(customLinkedList.isEmpty());
            Assertions.assertEquals(customLinkedList.size(), 0);
        }

        @Test
        void get() {
            Assertions.assertTrue(customLinkedList.contains(test));
            Assertions.assertEquals(test, customLinkedList.get(customLinkedList.size()));
        }

        @Test
        void indexOf() {
            Assertions.assertTrue(customLinkedList.contains(test));
            Assertions.assertEquals(customLinkedList.indexOf(test), customLinkedList.size() - 1);
        }

        @Test
        void lastIndexOf() {
            Assertions.assertEquals(customLinkedList.size() - 1, customLinkedList.lastIndexOf(test));
            customLinkedList.add(test);
            customLinkedList.add(test);
            Assertions.assertNotEquals(customLinkedList.indexOf(test), customLinkedList.lastIndexOf(test));
        }

        @Test
        void lastIndexOfObjectIsNull() {
            Object object = null;
            Assertions.assertEquals(customLinkedList.lastIndexOf(object), -1);
        }

        @Test
        void lastIndexOfObjectIsNulll() {
            String object = null;
            customLinkedList.addAll(Arrays.asList(object, object, object));
            Assertions.assertEquals(customLinkedList.lastIndexOf(object), customLinkedList.size() - 1);
        }

        @Test
        void set() {
            customLinkedList.set(2, test);
            Assertions.assertEquals(test, customLinkedList.get(2));
        }
    }
}