package sorting;

public class SumMinMaxElement {
    public static void main(String[] args) {
        int[] array = {64, 32, 25, 12, 22, 11, 90};
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int sum = min + max;
        System.out.println(sum);
    }
}
