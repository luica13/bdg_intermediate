package CustomHashSet;
import java.util.Iterator;


public interface SetInterface {
    boolean add(Object element);
    boolean remove(Object element);
    boolean contains(Object element);
    Iterator iterator();
    int size();
}
