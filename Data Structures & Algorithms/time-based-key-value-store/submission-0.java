class TimeMap {
    private class Valuation {
        public int timestamp;
        public String value;

        public Valuation(int t, String s) {
            this.timestamp = t;
            this.value = s;
        }
    }

    HashMap<String, Deque<Valuation>> hm; 
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) {
           Deque<Valuation> q = new ArrayDeque<>();
           var newV = new Valuation(timestamp, value);
           q.push(newV);
           hm.put(key, q);
        } else {
            hm.get(key).push(new Valuation(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        for(Valuation v: hm.get(key)) {
            if(timestamp>=v.timestamp) {
                return v.value;
            }
        }
        return "";
    }
}
