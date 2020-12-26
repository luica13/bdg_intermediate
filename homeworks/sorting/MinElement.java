package sorting;

public class MinElement {
    public static void main(String[] args) {
        int[] array = {64, 32, 25, 12, 22, 11, 90};
        int minElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        System.out.println(minElement);
    }
}
