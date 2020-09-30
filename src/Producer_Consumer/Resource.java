package Producer_Consumer;

public class Resource {
    int n;
    int flag=0;
    synchronized public void get()throws Exception
    {
        if(flag==0)
        {
            wait();
        }
        else
        {
            System.out.println("Get:="+n);
            notify();
            flag=0;
        }
    }
    synchronized public void put(int a)throws Exception
    {
        flag=1;
        this.n=a;
        System.out.println("Put:="+n);
        notify();
        wait();
    }
}
