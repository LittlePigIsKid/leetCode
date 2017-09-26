package ZigZagConversion;

public class Solution {
    public String convert(String s, int numRows) {
    	int n = numRows;
    	if(n==1)
    		return new String(s);
    	int[] array = new int[n+1];
        int size = s.length();
        StringBuilder builder = new StringBuilder(size);
        for(int i=1; i<n+1; i++)
            array[i] = i;
        // line one
        int index = 1;
        while(index<=size){
        	builder.append(s.charAt(index-1));
        	index += (n-1)*2;
        }
        
        
        for(index=2; index<=n-1; index++){
        	boolean flag = true;
        	while(array[index]<=size){
        		builder.append(s.charAt(array[index]-1));
        		if(flag){
        			flag = false;
        			array[index] += (n-index)*2;
        		}else{
        			flag = true;
        			array[index] += (index-1)*2;
        		}
        	}
        }
        
        index = n;
        while(index<=size){
        	builder.append(s.charAt(index-1));
        	index += (n-1)*2;
        }
        
        return builder.toString();
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	System.out.println( sol.convert("PAYPALISHIRING", 3) );
    }
}