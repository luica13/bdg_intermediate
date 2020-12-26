package sorting;

public class MaxElement {
    public static void main(String[] args) {
        int[] array = {64, 32, 25, 12, 22, 11, 90};
        int maxElement = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }
        System.out.println(maxElement);
    }
}
