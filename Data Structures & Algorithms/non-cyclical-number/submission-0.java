class Solution {
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int val = n;

        for (int i = 0; i < 7; i++) {
            val = getNext(val);
            if (val == 1) return true;
        }
        
        return false;
    }
}
