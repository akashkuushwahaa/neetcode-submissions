class Solution {
    public int getSum(int a, int b) {
        int c = 0;
        int ans = 0;
        for(int i=0; i<32; i++){
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;

            ans |= (c ^ bitA ^ bitB) << i;
            c = (bitA & bitB) | (bitA & c) | (bitB & c);
        }

        return ans;
    }
}