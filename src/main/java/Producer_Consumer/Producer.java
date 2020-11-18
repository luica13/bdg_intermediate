package Producer_Consumer;

public class Producer  implements Runnable{
    Resource r;
    Producer(Resource c)
    {
        r=c;
        Thread t1=new Thread(this,"Producer");
        t1.start();
    }
    public void run()
    {
        int i=0;
        try{
            while(i<10)
            {
                i++;
                r.put(i);
            }
        }
        catch(Exception e){}
    }
}
