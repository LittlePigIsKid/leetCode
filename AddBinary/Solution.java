package AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int n ;
        if(n1<n2)
            n = n2;
        else
            n = n1;
        boolean flag = false;
        Integer[] array = new Integer[n];
        for(int i=0; i<n; i++){
            int value1, value2, value;
            if(i<n1&&a.charAt(n1-1-i)=='1')
                value1 = 1;
            else
                value1 = 0;
            if(i<n2&&b.charAt(n2-1-i)=='1')
                value2 = 1;
            else 
                value2 = 0;
            if(flag){
                flag = false;
                value = value1 + value2 + 1;
                if(value>1){
                    flag = true;
                    array[n-i-1] = value%2;
                }else
                    array[n-i-1] = value;
            }else{
                value = value1 + value2;
                if(value>1){
                    flag = true;
                    array[n-i-1] = value%2;
                }else
                    array[n-i-1] = value;
            }
        }
        StringBuffer s = new StringBuffer(n);
        for(int i=0; i<n; i++){
        	if(array[i]==1)
        		s.append("1");
        	else
        		s.append("0");
        }
        	
        if(flag){
        	return "1"+s.toString();
        }
        else{
        	return s.toString();
        }
    }
    
    public static void main(String[] args){
    	String a = "010010101";
    	String b = "01";
    	System.out.println(new Solution().addBinary(a, b));
    }
}