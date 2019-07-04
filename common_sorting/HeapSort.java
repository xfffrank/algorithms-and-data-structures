import java.util.Arrays;

public class HeapSort {

    void heapSort(int[] arr) {
        if (arr.length < 2) return;
        // build max heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            buildHeap(arr, arr.length, i);
        }
        // sort the values
        for (int i = arr.length - 1; i >= 1; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildHeap(arr, i, 0);
        }
    }

    void buildHeap(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // find if the left or right value is bigger
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            // swap values and adjust the subtree that may be affected
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            buildHeap(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 23, 1};
        HeapSort sort = new HeapSort();
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
