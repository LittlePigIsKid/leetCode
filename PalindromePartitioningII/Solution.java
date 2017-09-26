package PalindromePartitioningII;

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n<1)
        	return 0;
        boolean flag = true;
        for(int i=1; i<n; i++){
            if(s.charAt(i)!=s.charAt(i-1))
                flag = false;
        }
        if(flag)
            return 0;
        boolean[][] array = getBoolean(s);
        int[][] cut = new int[n][n];
        for(int i=0; i<n; i++)
            cut[i][i] = 0;
        for(int length=1; length<n+1; length++){
	        for(int i=0; i<=n-length; i++){
               int j = i+length-1; 
               if(array[i][j])
                   cut[i][j] = 0;
               else{
                   cut[i][j] = cut[i][i]+ cut[i+1][j]+1;
                   for(int k=i; k<j; k++)
                       cut[i][j] = Math.min(cut[i][j], cut[i][k]+cut[k+1][j]+1);
               }
            }
        }
        return cut[0][n-1];
    }
    private boolean[][] getBoolean(String s){
        int n = s.length();
        boolean[][] array = new boolean[n][n];
        for(int length=1; length<=n; length++){
            for(int i=0; i+length<=n; i++){
            	int j = i+length-1;
                if(i+1<=j-1){
                	if(array[i+1][j-1]&&s.charAt(i)==s.charAt(j))
                		array[i][j] = true;
                }
                else
                	array[i][j] = s.charAt(i)==s.charAt(j);
            }
        }
        return array;
    }
    public static void main(String[] args){
    	String s = "abbab";
    	Solution  sol = new Solution();
    	System.out.println(sol.minCut(s));
    }
}