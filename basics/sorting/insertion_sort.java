import java.util.Arrays;

class InsertionSort {
	static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; array[j] < array[j - 1] && j > 0; j--) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {4, 35, 5, 1, 9, 32};
		System.out.println("排序前：" + Arrays.toString(arr));
		InsertionSort.insertSort(arr);
		System.out.println("排序后：" + Arrays.toString(arr));
	}
}