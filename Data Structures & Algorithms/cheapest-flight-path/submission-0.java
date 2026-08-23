class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       List<List<int[]>> list = new ArrayList<>();

       for(int i=0;i<n;i++) list.add(new ArrayList<>());
       for(int p[]:flights) list.get(p[0]).add(new int[] {p[1], p[2]});

       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        pq.offer(new int[] { src, 0, -1 });

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {         
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src]=0;
        while(!pq.isEmpty())
        {
            int[] arr = pq.poll();
            int node = arr[0];
            int len = arr[1];
            int nk = arr[2];
           
            for(int[] a: list.get(node)){
                int nnode = a[0];
                int nlen = a[1];
                int newDist = len + nlen;
                
                if (nk < k && dist[nnode] > newDist) {
                    dist[nnode] = newDist;
                    pq.offer(new int[] { nnode, newDist, nk+1 });
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}