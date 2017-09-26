package LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] array = helper();
        int max = 0;
        int start = 0;
        int end = -1;
        for(int i=0; i<s.length(); i++){
            int temp = s.charAt(i)-' ';
            if(array[temp]==-1){
                array[temp] = i;
                end = i;
            }
            else{
                max = Math.max(max, end-start+1);
                i = array[temp];
                array = helper();
                start = i+1;
            }
        }
        max = Math.max(max, end-start+1);
        return max;
    }
    private int[] helper(){
        int[] array = new int[128];
        for(int i=0; i<128; i++)
            array[i] = -1;
        return array;
    }
    
    public static void main(String[] args){
    	Solution sol = new Solution();
    	String s = "cdd";
    	System.out.println(sol.lengthOfLongestSubstring(s));
    }
}