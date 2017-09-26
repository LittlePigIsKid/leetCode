package LongestCommonProfix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1)
            return "";
        int begin = 0; 
        int end = strs[0].length()-1;
        for(int i=1; i<strs.length; i++){
            end = Math.min(end, strs[i].length()-1);
            for(int j=0; j<=end; j++){
                if(strs[i].charAt(j)!=strs[0].charAt(j)){
                    end = j-1;
                    break;
                }
            }
        }
        return strs[0].substring(begin, end+1);
    }
    public static void main(String[] args){
    	Solution s  =new Solution();
    	String[] strs = {"aa","a"};
    	System.out.println(s.longestCommonPrefix(strs));
    }
}