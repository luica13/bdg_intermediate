import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CustomHashSet {
    private Set<Integer> hashSet;

    public Set<Integer> getHashSet() {
        return hashSet;
    }

    //initialise new HashSet
    void initHashSet(Integer... intArray) {
        hashSet = new HashSet<>(Arrays.asList(intArray));
        System.out.println("New HashSet is initialised with " + hashSet + " values");
    }

    //add new item
    boolean addItem(int a) {
        return hashSet.add(a);
    }

    //remove new item
    boolean removeItem(int a) {
        return hashSet.remove(a);
    }

    //remove all items
    void removeAllItems() {
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " will be removed.");
            iterator.remove();
        }
        System.out.println("HashSet is empty.");
    }
}
