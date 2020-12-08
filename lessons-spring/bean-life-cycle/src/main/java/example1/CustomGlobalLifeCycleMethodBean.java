package example1;

public class CustomGlobalLifeCycleMethodBean {
    public CustomGlobalLifeCycleMethodBean() {
        System.out.println("Constructor of  bean is called !! ");
    }

    public void globalCustomDestroy() throws Exception {
        System.out.println("global custom destroy method of  bean is called !! ");
    }

    public void globalCustomInit() throws Exception {
        System.out.println("global custom Init  method of  bean is called !! ");
    }
}
