import java.util.Arrays;

class MergeSort {
	public void mergeSort(int[] arr, int low, int high) {
		// low 等于 high 时，不需要再划分
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			mergeArray(arr, low, mid, high);
		}
	}

	private void mergeArray(int[] arr, int low, int mid, int high) {
		// 临时数组，保存排序后的结果
		int[] temp = new int[high - low + 1];

		int i = low;
		int j = mid + 1;
		int k = 0; // 记录临时数组的索引
		while(i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= high) {
			temp[k++] = arr[j++];
		}

		// 把数据复制回原数组
		for (i = 0; i < temp.length; i++) {
			arr[low + i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] arr = {4, 35, 5, 1, 9, 32};
		System.out.println("排序前：" + Arrays.toString(arr));

		MergeSort ms = new MergeSort();
		ms.mergeSort(arr, 0, arr.length - 1);
		System.out.println("排序后：" + Arrays.toString(arr));
	}
}