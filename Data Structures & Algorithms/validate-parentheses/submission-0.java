class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            
            if(currChar == '(' || currChar == '{' || currChar == '[') {
                stack.push(currChar);
            } else {
                if(stack.isEmpty()) return false;
                
                Character top = stack.pop();
                
                if((currChar == ')' && top != '(') ||
                   (currChar == '}' && top != '{') ||
                   (currChar == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}