class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i] = node;
            i++;
            
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(i == numCourses) return ans;
        else return new int[0];
    }
}