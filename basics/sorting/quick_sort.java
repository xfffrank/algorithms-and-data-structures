import java.util.Arrays;

class QuickSort {
	public void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private void sort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			sort(array, low, pivotIndex - 1);
			sort(array, pivotIndex + 1, high);
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int end = high;

		while(low < high) {
			while(array[low] <= pivot && low < high)
				low++;
			while(array[high] >= pivot && low < high)
				high--;

			swap(array, low, high);
		}
		// 循环结束前多进行了一次交换，所以需交换回来
		swap(array, low, high);

		// 轴值设置为最后一个元素，故需要与右半部分的第一个值交换
		swap(array, low, end);

		// System.out.println(array[low]);
		// 循环结束时， low 的值为右半部分第一个元素的索引
		return low;
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = {4, 35, 5, 1, 9, 32};
		System.out.println("排序前：" + Arrays.toString(arr));
		qs.quickSort(arr);
		System.out.println("排序后：" + Arrays.toString(arr));
	}
}