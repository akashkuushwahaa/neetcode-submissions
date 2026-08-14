class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis = new int[m][n];
        Queue <int[]> q=new LinkedList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i==0 || j==0|| i==m-1 || j==n-1) {
                    if (board[i][j]=='O'){
                        q.add(new int[]{i,j});
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while (!q.isEmpty()){
            int[] node=q.poll();
            int row=node[0];
            int col=node[1];
            
            for (int i=0; i<4; i++){
                int rx=row+dx[i];
                int ry=col+dy[i];
                if (rx>=0 && rx<m && ry>=0 && ry<n && board[rx][ry]=='O' && vis[rx][ry]!=1){
                    q.add(new int[]{rx,ry});
                    vis[rx][ry]=1;
                }
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (vis[i][j]==0) board[i][j]='X';
            }
        }
    }
}