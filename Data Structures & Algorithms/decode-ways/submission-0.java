class Solution {
    int[] dp ;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0,s);
    }

    public int helper(int i , String s){
        if(i >= s.length()) return 1;

        if(dp[i] != -1) return dp[i];

        int onePick  = 0;
        int twoPick  = 0;

        if(isValid(s.substring(i,i+1))){
            onePick = helper(i+1,s);
        }

        if(i < s.length()-1 && isValid(s.substring(i,i+2))){
            twoPick = helper(i+2,s);
        }

        return dp[i] = (onePick + twoPick);
    }

    public boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);

        if(num <=26) return true;
        return false;
    }
}  