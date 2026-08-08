class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        backTrack(s, answer, 0, new ArrayList<>());
    return answer;
    }
    public void backTrack(String s, List<List<String>> ans, int index, List<String> ls) 
    {   
        if(index == s.length())
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i = index; i<s.length(); i++)
        {
            String curr = s.substring(index, i+1);
            if(check(curr))
            {
                ls.add(curr);
                backTrack(s, ans, i+1, ls);
                ls.remove(ls.size()-1);
            }
        }
    }
    public boolean check(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start<=end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
    return true;
    }
}