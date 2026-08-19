class Solution {

    public int swimInWater(int[][] grid) {

        int directions[][] = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int n = grid.length;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2])
            );

        int times[][] = new int[n][n];

        for (int row[] : times) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        times[0][0] = grid[0][0];

        pq.offer(new int[]{
            0, 0, grid[0][0]
        });

        while (!pq.isEmpty()) {

            int node[] = pq.poll();

            int x = node[0];
            int y = node[1];
            int maxTime = node[2];

            if (maxTime > times[x][y]) {
                continue;
            }

            if (x == n - 1 && y == n - 1) {
                return maxTime;
            }

            for (int dir[] : directions) {

                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < n) {

                    int newTime =
                        Math.max(maxTime, grid[nx][ny]);

                    if (newTime < times[nx][ny]) {

                        times[nx][ny] = newTime;

                        pq.offer(new int[]{
                            nx, ny, newTime
                        });
                    }
                }
            }
        }

        return -1;
    }
}