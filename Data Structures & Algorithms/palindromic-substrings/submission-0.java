class Solution {
    public int countSubstrings(String s) {
        int response = 0;
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
                response++;
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while (left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
                response++;
                left--;
                right++;
            }
        }
        return response;
    }
}