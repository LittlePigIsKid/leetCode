package DecodeWays;

public class Solution {
    public int numDecodings(String s) {
        int previous = 0;
        int current = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                if(i-1<0||s.charAt(i-1)>='3')
                    continue;
                else if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    int value = current;
                    current = Math.max(current, previous+1);
                    previous = value;
                }
            }else if(s.charAt(i)>='7'){
                int value = current;
                current = Math.max(previous, current);
                previous = value;
            }else{
                if(i-1>=0&&(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')){
                    previous++;
                    current++;
                    int value = current;
                    current = Math.max(previous, current);
                    previous = value;
                }else{
                	int value = current;
                	current++;
                    current = Math.max(current, previous);
                    previous = value;
                }
            }
        }
        return current;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	String s = "27";
    	System.out.println(sol.numDecodings(s));
    }
}