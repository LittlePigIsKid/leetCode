package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if('['==c||'{'==c||'('==c)
                stack.push(c);
            else{
                if(stack.empty())
                    return false;
                char temp = stack.pop();
                if((c==']'&&temp=='[')||(c=='}'&&temp=='{')||(c==')'&&c=='('))
                	return true;
                return false;
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
    public static void main(String[] args){
    	System.out.println(new Solution().isValid("[]"));
    }
}