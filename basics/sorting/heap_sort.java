import java.util.Arrays;

class HeapSort {
	public void heapSort(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			// 最大堆初始化，从最后一个父节点开始调整
			maxHeapify(arr, i, arr.length - 1);
		}

		for (int i = arr.length - 1; i > 0; i--) {
			// 排好序后，将根节点（最大值）与最后一个节点交换
			swap(arr, 0, i);
			// 重新调整成最大堆
			maxHeapify(arr, 0, i - 1);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void maxHeapify(int[] arr, int start, int end) {
		int dad = start;
		int son = 2 * dad + 1; // 左子节点
		while (son <= end) {
			// 将父节点与子节点中值较大的一个进行比较
			if (son + 1 <= end && arr[son] < arr[son + 1]) {
				son++;
			}
			if (arr[dad] > arr[son]) {
				// 父节点比子节点的值都大，则无需调整
				return;
			}
			else {
				swap(arr, dad, son);
				dad = son;
				son = 2 * dad + 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {4, 35, 5, 1, 9, 32};
		System.out.println("排序前：" + Arrays.toString(arr));

		HeapSort hs = new HeapSort();
		hs.heapSort(arr);
		System.out.println("排序后：" + Arrays.toString(arr));
	}
}