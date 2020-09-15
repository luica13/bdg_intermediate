public class Main {
    public static void main(String[] args) {
        CustomHashSet customHashSet = new CustomHashSet();
        customHashSet.initHashSet(5, 6, 1, 9, 4);
        if (customHashSet.addItem(4)) {
            System.out.println("Number is added and new HashSet is: " + customHashSet.getHashSet());
        }
        if (customHashSet.removeItem(5)) {
            System.out.println("Number is removed and new HashSet is: " + customHashSet.getHashSet());
        }
        customHashSet.removeAllItems();
    }
}
