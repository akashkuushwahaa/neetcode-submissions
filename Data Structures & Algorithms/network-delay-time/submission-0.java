class Solution {
    class Pair1{
        int node;
        int time;
        Pair1(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    class Pair2{
        int ti;
        int no;
        Pair2(int ti,int no){
            this.ti=ti;
            this.no=no;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        int m=times.length;
        int res[]=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair1>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u=times[i][0];
            int v=times[i][1];
            int t=times[i][2];
            adj.get(u).add(new Pair1(v,t));
        }
        PriorityQueue<Pair2> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.ti,b.ti)
        );
        pq.add(new Pair2(0,k));
        res[k]=0;

        while(!pq.isEmpty()){
            Pair2 p=pq.poll();
            int time=p.ti;
            int nodee=p.no;

            if(time>res[nodee]){
                continue;
            }
            for(Pair1 pp: adj.get(nodee)){
                int adjnode=pp.node;
                int tim=pp.time;
                if(time+tim<res[adjnode]){
                    res[adjnode]=time+tim;
                    pq.add(new Pair2(time+tim,adjnode));
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(res[i]>ans){
                ans=res[i];
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
        
    }
}