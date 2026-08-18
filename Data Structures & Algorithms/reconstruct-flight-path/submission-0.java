class Solution {

    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.get(t.get(0)).add(t.get(1));
        }

        dfs("JFK");

        return result;
    }

    public void dfs(String airport) {

        PriorityQueue<String> pq = map.get(airport);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }

        result.addFirst(airport);
    }
}