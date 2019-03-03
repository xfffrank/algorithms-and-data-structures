class Solution {
    public void rotate(int[] nums, int k) {
        if(k >= nums.length) {
            k -= nums.length;
        }
        
        // 先填充新数组的前半部分
        int []array = new int[nums.length];
        for (int i = nums.length - k; i < nums.length; i++) {
            array[i - nums.length + k] = nums[i];
        }
        
        for (int i = 0; i < nums.length - k; i++) {
            array[i + k] = nums[i];
        }
        
		// for(int i = 0; i < nums.length; i++) {
		// nums[i] = array[i];
		// 	// System.out.println(nums[i]);
		// }
        System.arraycopy(array, 0, nums, 0, array.length);
    }
}