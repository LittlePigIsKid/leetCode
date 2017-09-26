package DivideTwoInteger;

public class Solution {
    public int divide(int dividend, int divisor) {
        // over flow
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        //not vilid divisor
        }else if(divisor==0){
            return -1;
        }else if(dividend==0){
            return 0;
        }else{
        	long temp1 = dividend;
        	long temp2 = divisor;
            int result = (int)helper( Math.abs(temp1), Math.abs(temp2) );
            if(dividend>0&&divisor<0||dividend<0&&divisor>0)
                result = -result;
            return result;
        }
    }
    private long helper(long dividend, long divisor){
        System.out.println(dividend+","+ divisor);
        if(dividend<divisor)
            return 0;
        else if(divisor==dividend)
            return 1;
        else{
            long value = 1;
            while(value*divisor<=dividend){
                value = value<<1;
            }
            value = value>>1;
            return helper(dividend-divisor*value, divisor)+value;
        }
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int dividend = Integer.MIN_VALUE;
    	int divisor = -1010369383;
    	System.out.println(sol.divide(dividend, divisor));
    }
}