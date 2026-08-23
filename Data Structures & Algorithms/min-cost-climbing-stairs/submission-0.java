class Solution {
    public int minCostClimbingStairs(int[] a) {
        int n=a.length;
        int ans=0;
        int[] dp=new int[n];
        dp[0]=a[0];
        dp[1]=a[1];
        for(int i=2;i<n;i++){
            dp[i]=a[i]+Math.min(dp[i-1],dp[i-2]); 
        }
       ans=Math.min(dp[n-1],dp[n-2]);
       return ans;
    }
}