package MultiplyStrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String multiply(String num1, String num2) {
        List<Character> list = new ArrayList<Character>();
        int n1 = num1.length();
        int n2 = num2.length();
        int time = 0;
        int carry = 0;
        while(time<n1+n2-1){
            int value = carry;
            for(int i=time; i>=0; i--){
                if(i>=n1)
                    continue;
                int j = time-i;
                if(j>=n2)
                    continue;
                int temp1 = num1.charAt(n1-1-i)-'0';
                int temp2 = num2.charAt(n2-1-j)-'0';
                value += temp1*temp2;
            }
            carry = value/10;
            list.add((char)(value%10+'0'));
            time++;
        }
        StringBuilder builder = new StringBuilder();
        int n = list.size();
        boolean firstNoZero = false;
        if(carry!=0){
            builder.append((char)(carry+'0'));
            firstNoZero = true;
        }
        for(int i=0; i<n; i++){
            if(firstNoZero||list.get(n-1-i)!='0'){
            	builder.append(list.get(n-i-1));
            	firstNoZero = true;
            }else if(!firstNoZero&&i==n-1)
            	builder.append(list.get(n-i-1));
        }
        return builder.toString();
    }
    public static void main(String[] args){
    	String num1 = "100";
    	String num2 = "0";
    	Solution sol = new Solution();
    	System.out.println( sol.multiply(num1, num2) );
    }
}