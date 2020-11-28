package sorting;

public class SelectionSort {
    // 64, 32, 25, 12, 22, 11, 90
    // find min element and bring it in the begin
    // 11, 64, 32, 25, 12, 22, 90
    // 11, 12, 64, 32, 25, 22, 90
    // 11, 12, 22, 64, 32, 25, 90
    // 11, 12, 22, 25, 64, 32, 90
    // 11, 12, 22, 25, 32, 64, 90
    public static void main(String[] args) {
        int[] array = {64, 32, 25, 12, 22, 11, 90};
        for (int i = 0; i < array.length; i++) {
            int min_element = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_element]) {
                    min_element = j;
                }
                int temp = array[min_element];
                array[min_element] = array[i];
                array[i] = temp;
            }
        }
        //something went wrong
        System.out.print("Use Selection sort: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
