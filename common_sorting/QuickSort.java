import java.util.Arrays;

public class QuickSort {
    void quickSort(int[] arr) {
        if (arr.length == 0) return;
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }

    public int partition(int[] arr, int low, int high) {
        int pivotIndex = high--;
        while (true) {
            while (low < high && arr[low] < arr[pivotIndex]) low++;
            while (low < high && arr[high] > arr[pivotIndex]) high--;
            if (low >= high) break;
            swap(arr, low, high);
        }
        swap(arr, pivotIndex, low);
        return low;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = {5, 4, 1, 3, 3, 2};
        qs.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
