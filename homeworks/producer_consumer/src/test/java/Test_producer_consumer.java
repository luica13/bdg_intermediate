import com.company.Main;
import com.company.Producer;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class Test_producer_consumer {

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
    void test_Produce() throws InterruptedException {
        Main.PC pc = new Main.PC();

        // Create producer thread
        Thread t1 = new Thread(new Producer(pc));
        t1.start();
        while (!t1.getState().equals( Thread.State.WAITING))
        {
            Thread.sleep(1000);
        }

        LinkedList<Integer> list;
        int capacity;
        try {

            Field field_capacity = pc.getClass().getDeclaredField("capacity");
            field_capacity.setAccessible(true);
            capacity = (int)field_capacity.get(pc);

            Field field_list = pc.getClass().getDeclaredField("list");
            field_list.setAccessible(true);
            list = (LinkedList<Integer>)field_list.get(pc);

            Assertions.assertEquals(list.size(),capacity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }




    }
}
