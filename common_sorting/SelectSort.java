import java.util.Arrays;

public class SelectSort {
    void selectSort(int[] arr) {
        if (arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        SelectSort ss = new SelectSort();
        int[] arr = {5, 4, 1, 3, 2};
        ss.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
