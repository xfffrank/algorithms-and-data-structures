class Solution {
    // Better solution
    // 计算第 j 个元素到第 i 个元素有多少个不同的元素
    // 用 j 表示目标子集的起始位置，i 表示目标子集的结束位置
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);  // 重置目标子集的起始位置到当前元素的下一个位置
            }
            map.put(s.charAt(i), i);  // 记录元素的位置
            max = Math.max(max, i - j + 1);
        }
        return max;
    }


    // My solution
    public int lengthOfLongestSubstring1(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        
        if (ch.length == 0) {
            return 0;
        } else if (ch.length == 1) {
            return 1;
        }
        int max = 1;
        
        for(int i = 0; i < ch.length - 1; i++) {
            int remain = ch.length - (i + 1);
            int len = 1;
            map.clear();
            map.put(ch[i], 1);
            for (int j = i + 1; j < ch.length; j++) {
                if (map.get(ch[j]) == null) {
                    len += 1;
                    map.put(ch[j], 1);
                } else {
                    break;
                }
            }
            if (len > max) {
                max = len;
            }
            if (len >= remain) {
                break;
            }
        }
        return max;
    }
}