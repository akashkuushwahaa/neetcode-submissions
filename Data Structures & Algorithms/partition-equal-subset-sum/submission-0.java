class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) return false;

        int target = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = dp[ind - 1][t];
                boolean take = false;
                if (nums[ind] <= t) {
                    take = dp[ind - 1][t - nums[ind]];
                }

                dp[ind][t] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }
}