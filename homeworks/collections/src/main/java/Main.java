public class Main {
    public static void main(String[] args) {
        CustomHashSet<Integer> customHashSet = new CustomHashSet<>();
        customHashSet.initHashSet(5, 6, 1, 9, 4);
        if (customHashSet.addItem(4)) {
            System.out.println("New item is added and new HashSet is: " + customHashSet.getHashSet());
        }
        if (customHashSet.removeItem(5)) {
            System.out.println("An item is removed and new HashSet is: " + customHashSet.getHashSet());
        }
        customHashSet.removeAllItems();
    }
}
