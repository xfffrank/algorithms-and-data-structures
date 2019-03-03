class Solution {
    public int firstUniqChar(String s) {
        // 将字符串转换为字符数组
        char [] arr = s.toCharArray();
        
        // 两重循环，第二重循环从第一个循环的元素当前位置开始；
        // 对重复元素置‘0’，循环起始判断该元素是否为‘0’，是则进入下一次循环；
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                continue;
            }
            
            boolean temp = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    temp = true;
                    arr[j] = '0';
                }
            }
            if (temp == false && arr[i] != '0') {
                return i;
            }
        }
        
        return -1;
    }
}