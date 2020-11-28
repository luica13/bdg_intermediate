package sorting;

public class BubbleSort {
    //FIRST PASS                       //SECOND PASS                    //THIRD PASS                    //FORTH PASS
    // given a  5, 8, 4, 7, 6          //we have  5, 4, 7, 6, 8         //we have  4, 7, 6, 5, 8        //we hae  4, 6, 5, 7, 8
    //1-step   5, 8, 4, 7, 6           //1-step   4, 5, 7, 6, 8         //1-step   4, 7, 6, 5, 8        //1-step  4, 6, 5, 7, 8
    //2-step   5, 4, 8, 7, 6           //2-step   4, 7, 5, 6, 8         //2-step   4, 6, 7, 5, 8        //2-step  4, 5, 6, 7, 8
    //3-step   5, 4, 7, 8, 6           //3-step   4, 7, 6, 5, 8         //3-step   4, 6, 5, 7, 8
    //4-step   5, 4, 7, 6, 8           //4-step   4, 7, 6, 5, 8

    public static void main(String[] args) {
        //int[] array = {5, 8, 4, 7, 6};
        int[] array = {64, 32, 25, 12, 22, 11, 90};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("Use Bubble sort: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
