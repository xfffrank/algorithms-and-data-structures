class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 将nums2作为比较对象，nums1作为外层循环
        // 另外新建两个数组、一个用于保存交集--nums3、一个用于记录nums2的值是否已经出现在交集中--record
        // 最后将nums3中的有效数据复制到一个新数组--result，并返回该数组
        boolean [] record = new boolean[nums2.length];
        int [] nums3 = new int[nums2.length];
        int index = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    if (! record[j]) {
                        nums3[index] = nums1[i];
                        index ++;
                        record[j] = true;
                        break;
                    }
                }
            }
                
        }
        
        int [] result = new int[index];
        if (index > 0) {
            for (int i = 0; i < index; i++) {
                result[i] = nums3[i];
            }
            return result;
        }
        else {
            return result;
        }
        
        
    }
}