class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long total = fun(piles, mid);

            if (total <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    long fun(int[] nums, int hour) {

        long totalhour = 0;

        for (int i = 0; i < nums.length; i++) {
            totalhour += (nums[i] + hour - 1) / hour;
        }

        return totalhour;
    }
}