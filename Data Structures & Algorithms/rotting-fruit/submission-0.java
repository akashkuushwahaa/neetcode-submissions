class Solution {
    public int orangesRotting(int[][] grid) {
       int n = grid.length ;
       int m = grid[0].length ;

       boolean[][] visited = new boolean[n][m] ;
       Queue<int[]> queue = new LinkedList<>() ;
       int countFresh = 0 ;
       for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){
            if(grid[i][j] == 2){
                queue.offer(new int[]{i , j});
                visited[i][j] = true ;
            }else if(grid[i][j] == 1){
                countFresh++;
            }
        }
       }
        if(countFresh == 0){
            return 0 ;
        }
        int countUnit = -1 ;
        int[][] directions = {{-1 , 0}, {1 , 0},{0 , -1},{0 , 1}};

        while(!queue.isEmpty()){
            countUnit++;
            int size = queue.size() ;
            for(int k = 0 ; k < size ; k++){
                int[] ar = queue.poll() ;
                for(int[] dir : directions){
                    int x = dir[0] + ar[0];
                    int y = dir[1] + ar[1];
                    if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0 || visited[x][y])
                        continue;
                    
                    visited[x][y] = true ;
                    countFresh--;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return countFresh == 0 ? countUnit : -1;

       }  
       
}