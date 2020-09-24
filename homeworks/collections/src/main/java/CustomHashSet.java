import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CustomHashSet<T> {
    private Set<T> hashSet;

    public Set<T> getHashSet() {
        return hashSet;
    }

    //initialise new HashSet
    @SafeVarargs
    final void initHashSet(T... array) {
        hashSet = new HashSet<>(Arrays.asList(array));
        System.out.println("New HashSet is initialised with " + hashSet + " values");
    }

    //add new item
    boolean addItem(T a) {
        return hashSet.add(a);
    }

    //remove new item
    boolean removeItem(T a) {
        return hashSet.remove(a);
    }

    //remove all items
    void removeAllItems() {
        Iterator<T> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " will be removed.");
            iterator.remove();
        }
        System.out.println("HashSet is empty.");
    }
}
