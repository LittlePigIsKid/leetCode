package CountNumbersWithUniqueNumbers;

public class Solution {
	public int countNumbersWithUniqueDigits(int n) {
        if(n>=10)
            return 3265920;
        
        int auxiliary = 9;
        if(n==0)
        	return 1;
        if(n==1)
        	return 10;
        
        int result = 10;
        for(int i=9; i>10-n; i--){
        	auxiliary *= i;
        	result += auxiliary;
        }
        return result;
	}
        public static void main(String[] args){
    	Solution sol = new Solution();
    	int n = 3;
    	System.out.println(sol.countNumbersWithUniqueDigits(n));
    }
}