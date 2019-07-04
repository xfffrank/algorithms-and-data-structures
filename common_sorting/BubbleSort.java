import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public BubbleSort(){};

    public void bubbleSort(int[] arr) {
        if (arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 67, 3, 5, 45};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
