class Solution {
    List<String> ans = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backtrack(0, digits, map, new StringBuilder());
        return ans;
    }

    private void backtrack(int index, String digits, String[] map, StringBuilder curr) {
        if (curr.length() == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (char ch : letters.toCharArray()) {
            curr.append(ch);
            backtrack(index + 1, digits, map, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
