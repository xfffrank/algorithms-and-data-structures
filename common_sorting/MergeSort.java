import java.util.Arrays;

public class MergeSort {
    void mergeSort(int[] arr) {
        if (arr.length == 0) return;
        mergeCore(arr, 0, arr.length - 1);
    }

    void mergeCore(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeCore(arr, low, mid);
        mergeCore(arr, mid + 1, high);
        int[] temp = new int[high - low + 1];
        int i = mid, j = high, index = temp.length - 1;
        while(i >= low && j > mid) {
            if (arr[j] > arr[i]) temp[index--] = arr[j--];
            else temp[index--] = arr[i--];
        }
        while (i >= low) temp[index--] = arr[i--];
        while (j > mid) temp[index--]= arr[j--];
        for (i = 0; i < temp.length; i++)
            arr[low + i] = temp[i];
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {5, 4, 1, 3, 2, 34, 27, 2};
        ms.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
