import java.util.Arrays;

public class SelectionSort {
	/*
	第一轮循环选择最小的数放在第一个位置，第二轮循环把次最小的数放在第二个位置，以此类推。
	内层循环进行时没有进行数据交换，每轮循环后检查是否需要交换。
	*/
	static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i; j < array.length - 1; j++) {
				if (array[j + 1] < array[min]) {
					min = j + 1;
				}
			}

			if (min != i) {
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {4, 35, 5, 1, 9, 32};
		SelectionSort.selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}