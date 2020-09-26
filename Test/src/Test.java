import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args)  {
       Thread t=Thread.currentThread();
        System.out.println("Current Thread: "+t);
        t.setName("MyThread");
        System.out.println("After Name Change: "+t);
        for(int i=5;i>0;i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
