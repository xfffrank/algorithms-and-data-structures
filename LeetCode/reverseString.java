class Solution {
    public String reverseString(String s) {
        /*
        将输入的String转换为字符数组，创建一个与该数组长度相同的字符数组，用于保存反转结果。
        最后将字符数据转换为字符串。
        */
        char [] arr = s.toCharArray();
        char [] result = new char[arr.length];
        
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            result[i] = arr[len - i - 1];
        }
        
        return new String(result);
    }
}