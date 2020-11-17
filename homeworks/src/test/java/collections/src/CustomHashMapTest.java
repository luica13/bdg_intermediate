package collections.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CustomHashMapTest {

    CustomHashMap<Object, Object> customHashMap;
    Integer testKey;
    String testValue;

    @BeforeEach
    void setUp() {
        customHashMap = new CustomHashMap<>();
        testKey = 1;
        testValue = "one";
    }

    @Test
    void put() {
        customHashMap.put(testKey, testValue);
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, customHashMap.size()),
                () -> Assertions.assertSame(testValue, customHashMap.get(testKey),
                        () -> String.format("assertion failed: Expected value %s, actual result %s", customHashMap.get(testKey), testValue))
        );
    }

    @Nested
    class CustomHashMapOtherMethods {
        @BeforeEach
        void setUp() {
            customHashMap.put(2, "two");
            customHashMap.put(3, "three");
            customHashMap.put(4, "four");
        }

        @Test
        void get() {
            Assertions.assertEquals("two", customHashMap.get(2));
        }

        @Test
        void remove() {
            int size = customHashMap.size();
            Assertions.assertTrue(customHashMap.remove(2));
            Assertions.assertEquals(size - 1, customHashMap.size());
        }
    }
}