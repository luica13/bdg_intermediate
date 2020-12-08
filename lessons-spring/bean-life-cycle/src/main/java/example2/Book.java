package example2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Book implements InitializingBean, DisposableBean {

    private String bookName;

    public Book() {
        System.out.println("Constructor of Book bean is called !! ");
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public void customInit() {
        System.out.println("Called custom init method from " + this.getClass().getName());
    }
    public void customDestroy() {
        System.out.println("Called custom destroy method from " + this.getClass().getName());
    }

    //seventh step
    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method of Book bean called !! ");
    }

    //fifth step
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method of Book bean is called !! ");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
