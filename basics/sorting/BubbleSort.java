import java.util.Arrays;

public class BubbleSort {
	/*
	对 n 个数进行排序，最多需要 n - 1 次；因为每次循环都把该轮循环中最大的数放到最后，所以在最差的情况中，第 n - 1 次循环后数组有序。
	第一轮循环将最大的数放到最后一个位置，第二轮循环将次最大的数放到倒数第二个位置，
	每轮循环比较的次数比前一轮循环少 1，
	用 flag 标记该轮循环是否发生过交换，
	没有说明已排好序。
	*/
	static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					flag = true;
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			if (flag == false) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {4, 35, 5, 1, 9, 32};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
}