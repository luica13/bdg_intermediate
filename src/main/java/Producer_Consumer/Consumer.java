package Producer_Consumer;

public class Consumer implements Runnable{
    Resource r;
    Consumer(Resource c)
    {
        r=c;
        Thread t=new Thread(this,"Consumer");
        t.start();
    }
    public void run()
    {
        try{
            while(true)
            {
                r.get();
                //System.out.println(r.get());
            }
        }
        catch(Exception e){}
    }
}
