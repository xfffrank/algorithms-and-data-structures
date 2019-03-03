class MapSum {
    HashMap<String, Integer> map;
    HashMap<String, Integer> score;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap();
        score = new HashMap();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);  // 计算相同键对应的新值与原值的差异
        map.put(key, val); // 覆盖键值
        
        String prefix = "";
        for(char c:key.toCharArray()) {
            prefix += c;
            score.put(prefix, score.getOrDefault(prefix, 0) + delta);
        }
    }
    
    public int sum(String prefix) {
        return score.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */