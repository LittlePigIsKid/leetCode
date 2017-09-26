package RegularExpressionMatching;

public class Solution {
	    public boolean isMatch(String s, String p) {
	        return helper(s, 0, p, 0);
	    }
	    private boolean helper(String s, int i, String p, int j){
	        if(p.length()==j)
	            return s.length()==i;
	        else if(p.length()==j+1){
	        	if(s.length()==i)
	        		return false;
	            
	        	if(match(s.charAt(i), p.charAt(j)))
	            	return helper(s, i+1, p, j+1);
	            
	        	return false;
	        }else{
	            char temp = p.charAt(j+1);
	            if(temp=='*'){
	            	if(s.length()==i)
		        		return helper(s, i, p, j+2);
	            	if(!match(s.charAt(i), p.charAt(j)))
	            		return helper(s, i, p, j+2);
	            	else{
		                while(s.length()>i&&match(s.charAt(i), p.charAt(j))){
		                    if(helper(s, i, p, j+2))
		                        return true;
		                    i++;
		                }
		                return helper(s, i, p, j+2);
	            	}

	            }else{
	            	if(s.length()==i)
	            		return false;
	                return match(s.charAt(i), p.charAt(j))&&helper(s, i+1, p, j+1);
	            }
	        }
	    }
	    private boolean match(char a, char b){
	        if(a==b||b=='.')
	            return true;
	        return false;
	    }

    public static void main(String[] args){
    	Solution sol = new Solution();
    	String a = "a";
    	String b = "ab*";
    	System.out.println(sol.isMatch(a, b));
    }
}