class Solution {
    public int lengthOfLIS(int[] a) {
        int n=a.length;
        int max=0;
        if(n==1){
            return 1;
        }
        int ans=0;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
            if(a[j]<a[i]){
            dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}