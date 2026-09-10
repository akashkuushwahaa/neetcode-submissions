class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int[] minDist = new int[n];

        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        minDist[0] = 0;
        boolean[] used = new boolean[n];
        int totalCost = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!used[i] && (u == -1 || minDist[i] < minDist[u])) {
                    u = i;
                }
            }
            used[u] = true;
            totalCost += minDist[u];

            for (int v = 0; v < n; v++) {
                if (!used[v]) {
                    int distance =
                        Math.abs(points[u][0] - points[v][0])
                        + Math.abs(points[u][1] - points[v][1]);
                    minDist[v] = Math.min(minDist[v], distance);
                }
            }
        }

        return totalCost;
    }
}