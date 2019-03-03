class BinarySearch {
    // 'arr' is a sorted array.
    static void search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                System.out.println(String.valueOf(key) + " can be found.");
                return;
            }
            else if (key < arr[mid]) {
                end = mid - 1;
            }
            else if (key > arr[mid]) {
                start = mid + 1;
            }
        }
        System.out.println(String.valueOf(key) + " cannot be found !");
        return;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 6, 9};

        BinarySearch.search(array, 5);
        BinarySearch.search(array, 7);
    }
}