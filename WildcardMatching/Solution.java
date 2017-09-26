package WildcardMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
    	if(p.length()==0)
    		return s.length()==0;
    	boolean[][] array = new boolean[p.length()][s.length()];
        return helper(s, 0, p, 0, array);
    }
    private boolean helper(String s, int i, String p, int j, boolean[][] array){
    	if(j==p.length())
            return s.length()==i;
    	
        //check whether we had compared chars of s[i] and p[j]
    	if(i<s.length()){
	    	if(array[j][i])
	        	return false;
	    	//if had not checked s[i] and p[j]
	    	array[j][i] = true;
    	}
        if(p.charAt(j)=='*'){
        	int index = j;
        	while(p.length()>j&&p.charAt(index)==p.charAt(j))
        		j++;
            while(i<=s.length()){
                if(helper(s, i, p, j, array))
                    return true;
                i++;
            }
            return false;
        }else{
            if(s.length()==i)
                return false;
            if(match(s.charAt(i), p.charAt(j)))
                return helper(s, i+1, p, j+1, array);
            return false;
        }
    }
    private boolean match(char a, char b){
        if(a==b)
            return true;
        if(b=='?')
            return true;
        return false;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	String s = "aa";
    	String p = "?*";
    	System.out.println(sol.isMatch(s, p));
    }
}