class Solution {
    public String minWindow(String s, String t) {
        int[] tarr = new int[256];
        int[] sarr = new int[256];

        for(char ch : t.toCharArray()) {
            tarr[ch]++;
        }

        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int minStart = 0;

        for(int right = 0; right < s.length(); right++) {
            sarr[s.charAt(right)]++;

            while(compareArr(sarr, tarr)) {
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                sarr[s.charAt(left++)]--;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLength);
    }

    private boolean compareArr(int[] sarr, int[] tarr) {
        for(int i = 0; i < 256; i++) {
            if(tarr[i] > sarr[i]) {
                return false;
            }
        }
        return true;
    }
}