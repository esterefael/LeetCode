class TimeMap { 
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap tm = map.getOrDefault(key, new TreeMap<>());
        tm.put(timestamp, value);
        map.put(key, tm);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            Map.Entry<Integer, String> ce = map.get(key).floorEntry(timestamp);
            if(ce != null)
                return ce.getValue();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */